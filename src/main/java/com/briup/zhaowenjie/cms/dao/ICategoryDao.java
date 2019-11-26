package com.briup.zhaowenjie.cms.dao;

import com.briup.zhaowenjie.cms.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ICategoryDao extends JpaRepository<Category,Integer> {
    Category findById(int id);
}
