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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/link")
@Api(description = "链接处理器")
public class LinkController {

    @Autowired
    private ILinkService linkService;
    @Autowired
    private MessageUtil messageUtil;

    @ApiOperation("添加新的链接")
    @GetMapping("/add")
    public Message<Link> addLink(Link link) {
        Link link1 = linkService.addLink(link);
        return messageUtil.success(link1);
    }

    @ApiOperation("删除一个链接")
    @GetMapping("/remove")
    @ApiImplicitParam(name = "name",value = "要删除的链接的链接名",paramType = "query")
    public Message<Link> removeLink(String name) {
        linkService.removeLink(name);
        return messageUtil.success();
    }

    @ApiOperation("修改已有的链接")
    @GetMapping("/reset")
    public Message<Link> resetLink(Link link) {
        linkService.removeLink(link.getName());
        Link link1 = linkService.addLink(link);
        return messageUtil.success(link1);
    }

}
