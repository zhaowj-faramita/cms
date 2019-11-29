package com.briup.zhaowenjie.cms.web.controller;

import com.briup.zhaowenjie.cms.config.Message;
import com.briup.zhaowenjie.cms.config.MessageUtil;
import com.briup.zhaowenjie.cms.utils.CodeUtil;
import com.briup.zhaowenjie.cms.utils.JwtTokenUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(description = "登陆相关接口")
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    @Qualifier("userDetailServiceImpl")
    private UserDetailsService userDetailsService;


    @PostMapping("/form")
    @ApiOperation(value = "登入身份验证（JWT验证）", notes = "登入")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", paramType = "query", required = true),
            @ApiImplicitParam(name = "password", value = "密码", paramType = "query", required = true)
    })
    public void login(String username, String password) {
        // TODO 这里面不需要写任何代码，由UserDeatilsService去处理
    }

    @GetMapping("/getUserDetailByToken")
    @ApiOperation(value = "根据token得到用户信息")
    public Message<? extends Object> getUserDetailByToken(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        response.setContentType("application/json;charset=UTF-8");
        if (token != null && StringUtils.startsWith(token, JwtTokenUtils.TOKEN_PREFIX)) {
            token = StringUtils.substring(token, JwtTokenUtils.TOKEN_PREFIX.length());
            UserDetails details = userDetailsService.loadUserByUsername(JwtTokenUtils.getUsername(token));
            return MessageUtil.success(details);
        } else {
            return MessageUtil.error(CodeUtil.LOGINFAIL_CODE, "token失效");
        }
    }
}
