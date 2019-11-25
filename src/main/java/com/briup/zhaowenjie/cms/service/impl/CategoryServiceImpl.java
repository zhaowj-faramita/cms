package com.briup.zhaowenjie.cms.service.impl;

import com.briup.zhaowenjie.cms.bean.Category;
import com.briup.zhaowenjie.cms.dao.ICategoryDao;
import com.briup.zhaowenjie.cms.exception.CustomerException;
import com.briup.zhaowenjie.cms.service.ICategoryService;
import com.briup.zhaowenjie.cms.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void removeCategory(String name) throws CustomerException {
        if (name == null) {
            throw new CustomerException(CodeUtil.DEADLY_CODE, "removeCategory:参数为空");
        } else {
            iCategoryDao.deleteByName(name);
        }
    }
}
