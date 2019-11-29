package com.briup.zhaowenjie.cms.web.controller;

import com.briup.zhaowenjie.cms.config.Message;
import com.briup.zhaowenjie.cms.config.MessageUtil;
import com.briup.zhaowenjie.cms.utils.CodeUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/user")
@ApiIgnore
public class SecurityController {
    @GetMapping("/login")
    public Message requireAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        return MessageUtil.error(CodeUtil.LOGINFAIL_CODE, "访问的服务需要登录，请前往登录页");
    }
}
