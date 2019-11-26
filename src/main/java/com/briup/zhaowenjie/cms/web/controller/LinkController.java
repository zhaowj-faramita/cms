package com.briup.zhaowenjie.cms.web.controller;

import com.briup.zhaowenjie.cms.bean.Link;
import com.briup.zhaowenjie.cms.config.Message;
import com.briup.zhaowenjie.cms.config.MessageUtil;
import com.briup.zhaowenjie.cms.service.ILinkService;
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
@RequestMapping("/link")
@Api(description = "链接处理器")
public class LinkController {

    @Autowired
    private ILinkService linkService;

    @ApiOperation("添加新的链接或者修改一个已有的链接")
    @PostMapping("/addOrUpdate")
    public Message addLink(Link link) {
        linkService.addLink(link);
        return MessageUtil.success();
    }

    @ApiOperation("删除一个链接")
    @GetMapping("/remove")
    @ApiImplicitParam(name = "id", value = "要删除的链接的主键", paramType = "query", required = true)
    public Message removeLink(int id) {
        linkService.removeLink(id);
        return MessageUtil.success();
    }

    @ApiOperation("根据主键查询所有链接")
    @GetMapping("/queryById")
    @ApiImplicitParam(name = "id", value = "要查询的链接的主键", paramType = "query", required = true)
    public Message<Link> queryLinkById(int id) {
        return MessageUtil.success(linkService.queryLinkById(id));
    }

    @ApiOperation("查询所有链接")
    @GetMapping("/findAll")
    public Message<List<Link>> findAllLink() {
        return MessageUtil.success(linkService.findAll());
    }

}
