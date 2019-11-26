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
@Api(description = "栏目处理器")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;


    @ApiOperation("添加一个栏目或者修改一个已有的栏目")
    @PostMapping("/addOrUpdate")
    public Message addCategory(Category category) {
        iCategoryService.addCategory(category);
        return MessageUtil.success();
    }

    @ApiOperation("删除一个栏目")
    @GetMapping("/remove")
    @ApiImplicitParam(name = "id",value = "要删除的栏目的主键",paramType = "query",required = true)
    public Message removeCategory(int id) {
        iCategoryService.removeCategory(id);
        return MessageUtil.success();
    }

    @ApiOperation("根据主键查询栏目")
    @GetMapping("/queryById")
    @ApiImplicitParam(name = "id", value = "要查询的栏目的主键", paramType = "query", required = true)
    public Message<Category> queryCategoryById(int id) {
        return MessageUtil.success(iCategoryService.queryCategoryById(id));
    }

    @ApiOperation("查询所有栏目")
    @GetMapping("/findAll")
    public Message<List<Category>> findAllCategory() {
        return MessageUtil.success(iCategoryService.findAll());
    }


}
