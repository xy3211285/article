package com.mantou.article.controller;

import com.mantou.article.bean.Article;
import com.mantou.article.service.ArticleService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @PostMapping("/addArticle")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "category", value = "分类", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "title", value= "标题", dataType="string", paramType = "query", required = true),
            @ApiImplicitParam(name = "content", value= "内容", dataType="string", paramType = "query"),
            @ApiImplicitParam(name = "author", value= "作者", dataType="string", paramType = "query")
    })
    public Map<String, Object> addArticle(Article article) {
        return articleService.addArticle(article);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", dataType = "long", paramType = "query")
    })
    @PostMapping("/getArticleById")
    public Map<String, Object> getArticleById(Long id) {
        return articleService.getArticleById(id);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "category", value = "类别", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "title", value = "类别标题", dataType = "string", paramType = "query", required = true)
    })
    @PostMapping("/getArticleByCategory")
    public Map<String, Object> getArticleByCategory(String category, String title) {
        return articleService.getArticleByCategory(category, title);
    }

    @PostMapping("updateArticleByCategory")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "category", value = "分类", dataType = "string", paramType = "query", required = true),
            @ApiImplicitParam(name = "title", value= "标题", dataType="string", paramType = "query", required = true),
            @ApiImplicitParam(name = "content", value= "内容", dataType="string", paramType = "query"),
            @ApiImplicitParam(name = "author", value= "作者", dataType="string", paramType = "query")
    })
    public Map<String, Object> updateArticleByCategory(Article article) {
        return articleService.updateArticleByCategory(article);
    }
}
