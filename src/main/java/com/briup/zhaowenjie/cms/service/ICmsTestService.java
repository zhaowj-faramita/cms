package com.briup.zhaowenjie.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.briup.zhaowenjie.cms.bean.CmsTest;
import com.briup.zhaowenjie.cms.dao.ICmsTest;

public class ICmsTestService {
    @Autowired
    ICmsTest cmsTest;

    public void test() {
        CmsTest cmsTest = new CmsTest(1, "a", "b");
        this.cmsTest.save(cmsTest2);
        List<CmsTest> findAll = this.cmsTest.findAll();
        findAll.forEach(System.out::println);
    }
}
