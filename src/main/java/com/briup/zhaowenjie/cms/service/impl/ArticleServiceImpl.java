package com.briup.zhaowenjie.cms.service.impl;

import com.briup.zhaowenjie.cms.bean.Article;
import com.briup.zhaowenjie.cms.dao.IArticleDao;
import com.briup.zhaowenjie.cms.exception.CustomerException;
import com.briup.zhaowenjie.cms.service.IArticleService;
import com.briup.zhaowenjie.cms.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private IArticleDao articleDao;

    @Override
    public Article addArticle(Article article) throws CustomerException {
        if (article == null) {
            throw new CustomerException(CodeUtil.DEADLY_CODE, "addArticle:参数为空");
        } else {
            return articleDao.save(article);
        }
    }

    @Override
    public void removeArticle(String author) throws CustomerException {
        if (author == null) {
            throw new CustomerException(CodeUtil.DEADLY_CODE, "removeArticle:参数为空");
        } else {
            articleDao.deleteByAuthor(author);
        }
    }
}
