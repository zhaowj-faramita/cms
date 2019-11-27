package com.briup.zhaowenjie.cms.dao;

import com.briup.zhaowenjie.cms.bean.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArticleDao extends JpaRepository<Article,Integer> {
    Article findById(int id);
}
