package com.briup.zhaowenjie.cms.dao;

import com.briup.zhaowenjie.cms.bean.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IArticleDao extends JpaRepository<Article,Integer> {
    Article queryById(int id);
    List<Article>queryByCategory_id(int category_id);
}
