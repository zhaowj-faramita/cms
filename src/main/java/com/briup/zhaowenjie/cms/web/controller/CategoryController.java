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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@Api(description = "Category处理器")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private MessageUtil messageUtil;

    @ApiOperation("添加一个Category或者修改一个已有的Category")
    @PostMapping("/addOrUpdate")
    public Message<Category> addCategory(Category category) {
        Category category1 = iCategoryService.addCategory(category);
        return messageUtil.success(category1);
    }

    @ApiOperation("删除一个Category")
    @GetMapping("/remove")
    @ApiImplicitParam(name = "id",value = "要删除的Category的主键",paramType = "query",required = true)
    public Message<Category> removeCategory(int id) {
        iCategoryService.removeCategory(id);
        return messageUtil.success();
    }

    @ApiOperation("根据主键查询Category")
    @GetMapping("/queryById")
    @ApiImplicitParam(name = "id", value = "要删除的用户的主键", paramType = "query", required = true)
    public Message<Category> queryCategoryById(int id) {
        return messageUtil.success(iCategoryService.queryCategoryById(id));
    }

    @ApiOperation("查询所有Category")
    @GetMapping("/findAll")
    public Message<List<Category>> findAllCategory() {
        return messageUtil.success(iCategoryService.findAll());
    }


}
