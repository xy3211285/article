package com.mantou.article.service.impl;

import com.mantou.article.bean.Article;
import com.mantou.article.dao.ArticleDao;
import com.mantou.article.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService{
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleServiceImpl.class);
    @Resource
    private ArticleDao articleDao;

    public Map<String, Object> addArticle(Article article) {
        Map<String, Object> result = new HashMap<>();
        try {
            boolean isSaved = articleDao.addArticle(article);
            if (isSaved) {
                result.put("result", "success");
            } else {
                result.put("result", "failed");
                result.put("errMsg", "数据保存失败");
            }
        } catch (Exception e) {
            result.put("result", "failed");
            result.put("errMsg", "后台服务出错");
            LOGGER.error("保存失败", e);
        }
        return result;
    }

    @Override
    public Map<String, Object> getArticleById(Long id) {
        Map<String, Object> result = new HashMap<>();
        try {
            Article article = articleDao.getArticleById(id);
            if (article != null) {
                result.put("result", "success");
                result.put("data", article);
            } else {
                result.put("result", "failed");
                result.put("errMsg", "找不到该文章");
            }
        } catch (Exception e) {
            result.put("result", "failed");
            result.put("errMsg", "后台服务出错");
            LOGGER.error("查询文章失败", e);
        }
        return result;
    }

    @Override
    public Map<String, Object> getArticleByCategory(String category, String title) {
        Map<String, Object> result = new HashMap<>();
        try {
            Article article = articleDao.getArticleByCategory(category, title);
            if (article != null) {
                result.put("result", "success");
                result.put("data", article);
            } else {
                result.put("result", "failed");
                result.put("errMsg", "找不到该文章");
            }
        } catch (Exception e) {
            result.put("result", "failed");
            result.put("errMsg", "后台服务出错");
            LOGGER.error("查询文章失败", e);
        }
        return result;
    }

    @Override
    public Map<String, Object> updateArticleByCategory(Article art) {
        Map<String, Object> result = new HashMap<>();
        try {
            Article article = articleDao.getArticleByCategory(art.getCategory(), art.getTitle());
            if (article == null) {
                result.put("result", "failed");
                result.put("errMsg", "文章不存在");
            } else {
                articleDao.updateArticle(art);
                result.put("result", "success");
            }
        } catch (Exception e) {
            result.put("result", "failed");
            result.put("errMsg", "后台服务出错");
        }
        return result;
    }
}
