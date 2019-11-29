package com.briup.zhaowenjie.cms.service;

import com.briup.zhaowenjie.cms.bean.Category;
import com.briup.zhaowenjie.cms.bean.ex.CategoryEX;
import com.briup.zhaowenjie.cms.exception.CustomerException;

import java.util.List;

public interface ICategoryService {

    Category addCategory(Category category) throws CustomerException;

    void removeCategory(int id) throws CustomerException;

    Category queryCategoryById(int id) throws CustomerException;

    List<Category> findAll() throws CustomerException;

    List<CategoryEX> findAllCategoryEX() throws CustomerException;
}
