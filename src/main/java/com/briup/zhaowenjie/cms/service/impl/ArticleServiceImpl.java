package com.briup.zhaowenjie.cms.service.impl;

import com.briup.zhaowenjie.cms.bean.Article;
import com.briup.zhaowenjie.cms.dao.IArticleDao;
import com.briup.zhaowenjie.cms.exception.CustomerException;
import com.briup.zhaowenjie.cms.service.IArticleService;
import com.briup.zhaowenjie.cms.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private IArticleDao articleDao;

    @Override
    public Article addArticle(Article article) throws CustomerException {
        if (article == null) {
            throw new CustomerException(CodeUtil.DEADLY_CODE, "addArticle:参数为空");
        } else {
            article.setClickTimes(1);
            article.setPublishDate(new Date());
            System.out.println(article);
            return articleDao.save(article);
        }
    }

    @Override
    public void removeArticle(int id) throws CustomerException {
            articleDao.deleteById(id);
    }

    @Override
    public Article queryArticleById(int id) throws CustomerException {
        return articleDao.findById(id);
    }

    @Override
    public List<Article> findAll() throws CustomerException {
        return articleDao.findAll();
    }
}
