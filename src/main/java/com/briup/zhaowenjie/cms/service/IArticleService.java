package com.briup.zhaowenjie.cms.service;

import com.briup.zhaowenjie.cms.bean.Article;
import com.briup.zhaowenjie.cms.exception.CustomerException;

public interface IArticleService {

    Article addArticle(Article article) throws CustomerException;

    void removeArticle(String author) throws CustomerException;

}
