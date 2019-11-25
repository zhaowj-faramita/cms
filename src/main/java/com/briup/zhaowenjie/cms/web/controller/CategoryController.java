package com.briup.zhaowenjie.cms.web.controller;

import com.briup.zhaowenjie.cms.bean.Category;
import com.briup.zhaowenjie.cms.config.Message;
import com.briup.zhaowenjie.cms.config.MessageUtil;
import com.briup.zhaowenjie.cms.service.ICategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@Api(description = "Category处理器")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private MessageUtil messageUtil;

    @ApiOperation("添加一个Category")
    @GetMapping("/add")
    public Message<Category> addCategory(Category category) {
        Category category1 = iCategoryService.addCategory(category);
        return messageUtil.success(category1);
    }

    @ApiOperation("删除一个Category")
    @GetMapping("/remove")
    @ApiImplicitParam(name = "name",value = "要删除的Category的name",paramType = "query")
    public Message<Category> removeCategory(String name) {
        iCategoryService.removeCategory(name);
        return messageUtil.success();
    }

    @ApiOperation("修改已有的Category")
    @GetMapping("/reset")
    public Message<Category> resetCategory(Category category) {
        iCategoryService.removeCategory(category.getName());
        Category category1 = iCategoryService.addCategory(category);
        return messageUtil.success(category1);
    }

}
