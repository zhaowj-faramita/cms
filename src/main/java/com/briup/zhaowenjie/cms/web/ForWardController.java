package com.briup.zhaowenjie.cms.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ForWardController {
    @GetMapping("")
    public String testMapping(HttpServletRequest request) {
        return request.getParameter("id");
    }
}