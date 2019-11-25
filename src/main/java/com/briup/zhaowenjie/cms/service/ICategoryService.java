package com.briup.zhaowenjie.cms.service;

import com.briup.zhaowenjie.cms.bean.Category;
import com.briup.zhaowenjie.cms.exception.CustomerException;

public interface ICategoryService {

    Category addCategory(Category category) throws CustomerException;

    void removeCategory(String name) throws CustomerException;

}
