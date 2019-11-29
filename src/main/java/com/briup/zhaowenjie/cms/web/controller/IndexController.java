package com.briup.zhaowenjie.cms.web.controller;


import com.briup.zhaowenjie.cms.bean.ex.CategoryEX;
import com.briup.zhaowenjie.cms.config.Message;
import com.briup.zhaowenjie.cms.config.MessageUtil;
import com.briup.zhaowenjie.cms.service.ICategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/index")
@Api(description = "主页处理器")
public class IndexController {

    @Autowired
    ICategoryService iCategoryService;

    @ApiOperation("展示主页")
    @GetMapping("/showIndex")
    public Message<List<CategoryEX>> showIndex() {
        return MessageUtil.success(iCategoryService.findAllCategoryEX());
    }
}
