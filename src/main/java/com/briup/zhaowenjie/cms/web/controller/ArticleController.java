package com.briup.zhaowenjie.cms.web.controller;

import com.briup.zhaowenjie.cms.bean.Article;
import com.briup.zhaowenjie.cms.config.Message;
import com.briup.zhaowenjie.cms.config.MessageUtil;
import com.briup.zhaowenjie.cms.service.IArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
@Api(description = "文章处理器")
public class ArticleController {

    @Autowired
    private IArticleService iArticleService;


    @ApiOperation(value = "添加一个文章或者修改一个已有的文章",notes = "category开头的除了id项其他不需要输入")
    @PostMapping("/addOrUpdate")
    public Message addArticle(Article article) {
        iArticleService.addArticle(article);
        return MessageUtil.success();
    }

    @ApiOperation("删除一个文章")
    @GetMapping("/remove")
    @ApiImplicitParam(name = "id",value = "要删除的文章的主键",paramType = "query",required = true)
    public Message removeArticle(int id) {
        iArticleService.removeArticle(id);
        return MessageUtil.success();
    }

    @ApiOperation("根据主键查询文章")
    @GetMapping("/queryById")
    @ApiImplicitParam(name = "id", value = "要删除的文章的主键", paramType = "query", required = true)
    public Message<Article> queryArticleById(int id) {
        return MessageUtil.success(iArticleService.queryArticleById(id));
    }

    @ApiOperation("查询所有文章")
    @GetMapping("/findAll")
    public Message<List<Article>> findAllArticle() {
        return MessageUtil.success(iArticleService.findAll());
    }

    @ApiOperation("查询某栏目的所有文章")
    @GetMapping("/queryByCategory_id")
    @ApiImplicitParam(name = "category_id", value = "要查找的文章的主键", paramType = "query", required = true)
    public Message<List<Article>> findAllArticle(int category_id) {
        return MessageUtil.success(iArticleService.findArticleByCategoryId(category_id));
    }
}
