package com.briup.zhaowenjie.cms.web.handler;

import com.briup.zhaowenjie.cms.config.MessageUtil;
import com.briup.zhaowenjie.cms.utils.CodeUtil;
import com.briup.zhaowenjie.cms.utils.JwtTokenUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    @Qualifier("userDetailServiceImpl")
    private UserDetailsService userDetailsService;

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        try {
            User details = (User) userDetailsService.loadUserByUsername(authentication.getName());

            String token = JwtTokenUtils.TOKEN_PREFIX + JwtTokenUtils.createToken(details, false);
            // 重定向
            response.setHeader(JwtTokenUtils.TOKEN_HEADER, token);
            response.getWriter().write(objectMapper.writeValueAsString(MessageUtil.success(token)));
        } catch (Exception e) {
            response.getWriter().write(objectMapper.writeValueAsString(MessageUtil.error(CodeUtil.LOGINFAIL_CODE, "创建token失败，请与管理员联系")));
        }

    }
}
