package com.briup.zhaowenjie.cms.web.controller;

import com.briup.zhaowenjie.cms.bean.Article;
import com.briup.zhaowenjie.cms.bean.Category;
import com.briup.zhaowenjie.cms.config.Message;
import com.briup.zhaowenjie.cms.config.MessageUtil;
import com.briup.zhaowenjie.cms.service.IArticleService;
import com.briup.zhaowenjie.cms.service.ICategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
@Api(description = "Article处理器")
public class ArticleController {

    @Autowired
    private IArticleService iArticleService;
    @Autowired
    private MessageUtil messageUtil;

    @ApiOperation("添加一个Article")
    @GetMapping("/add")
    public Message<Article> addArticle(Article article) {
        Article category1 = iArticleService.addArticle(article);
        return messageUtil.success(category1);
    }

    @ApiOperation("删除一个Article")
    @GetMapping("/remove")
    @ApiImplicitParam(name = "author",value = "要删除的Article的author",paramType = "query")
    public Message<Article> removeArticle(String author) {
        iArticleService.removeArticle(author);
        return messageUtil.success();
    }

    @ApiOperation("修改已有的Article")
    @GetMapping("/reset")
    public Message<Article> resetArticle(Article article) {
        iArticleService.removeArticle(article.getAuthor());
        Article article1 = iArticleService.addArticle(article);
        return messageUtil.success(article1);
    }

}
