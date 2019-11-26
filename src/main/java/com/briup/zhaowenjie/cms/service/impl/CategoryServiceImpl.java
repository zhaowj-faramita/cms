package com.briup.zhaowenjie.cms.service.impl;

import com.briup.zhaowenjie.cms.bean.Category;
import com.briup.zhaowenjie.cms.dao.ICategoryDao;
import com.briup.zhaowenjie.cms.exception.CustomerException;
import com.briup.zhaowenjie.cms.service.ICategoryService;
import com.briup.zhaowenjie.cms.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryDao iCategoryDao;

    @Override
    public Category addCategory(Category category) throws CustomerException {
        if (category == null) {
            throw new CustomerException(CodeUtil.DEADLY_CODE, "addCategory:参数为空");
        } else {
            return iCategoryDao.save(category);
        }
    }

    @Override
    public void removeCategory(int id) throws CustomerException {
            iCategoryDao.deleteById(id);
    }

    @Override
    public Category queryCategoryById(int id) throws CustomerException {
        return iCategoryDao.findById(id);
    }

    @Override
    public List<Category> findAll() throws CustomerException {
        return iCategoryDao.findAll();
    }
}
