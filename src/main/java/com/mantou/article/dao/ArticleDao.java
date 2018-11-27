package com.mantou.article.dao;


import com.mantou.article.bean.Article;
import org.apache.ibatis.annotations.Param;

public interface ArticleDao {
    boolean addArticle(Article article);

    Article getArticleById(Long id);

    void updateArticle(Article art);

    Article getArticleByCategory(@Param(value = "category") String category,
                                 @Param(value = "title") String title);
}
