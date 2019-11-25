package com.briup.zhaowenjie.cms.dao;

import com.briup.zhaowenjie.cms.bean.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface IArticleDao extends JpaRepository<Article,Integer> {
    @Transactional
    void deleteByAuthor(String author);
}
