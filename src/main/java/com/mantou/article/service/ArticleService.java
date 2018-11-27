package com.mantou.article.service;


import com.mantou.article.bean.Article;

import java.util.Map;

public interface ArticleService {
    Map<String, Object> addArticle(Article article);

    Map<String, Object> getArticleById(Long id);

    Map<String, Object> getArticleByCategory(String category, String title);

    Map<String, Object> updateArticleByCategory(Article article);
}
