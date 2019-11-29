package com.briup.zhaowenjie.cms.service;

import com.briup.zhaowenjie.cms.bean.Article;
import com.briup.zhaowenjie.cms.exception.CustomerException;

import java.util.List;

public interface IArticleService {

    Article addArticle(Article article) throws CustomerException;

    void removeArticle(int id) throws CustomerException;

    Article queryArticleById(int id) throws CustomerException;

    List<Article> findAll() throws CustomerException;

    List<Article> findArticleByCategoryId(int category_id);
}
