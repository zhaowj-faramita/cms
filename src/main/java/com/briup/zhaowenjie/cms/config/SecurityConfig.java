package com.briup.zhaowenjie.cms.config;

import com.briup.zhaowenjie.cms.web.filter.JwtAuthenticationTokenFilter;
import com.briup.zhaowenjie.cms.web.handler.LoginFailHandler;
import com.briup.zhaowenjie.cms.web.handler.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * ClassName:WebSecurityConfig <br/>
 * Function: security 配置类 <br/>
 * Date: 2018年9月17日 上午10:23:44 <br/>
 *
 * @author wangzh
 * @version
 * @since JDK 1.8
 * @see
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailServiceImpl")
    private UserDetailsService userDetailService;

    @Bean
    public PasswordEncoder getPasswordEncoderBean() {
        return new BCryptPasswordEncoder();    //MD5加密算法
    }

    @Bean
    public JwtAuthenticationTokenFilter getauthenticationTokenFilterBean() {
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    public LoginSuccessHandler getLoginSuccessHandler() {
        return new LoginSuccessHandler();
    }

    @Bean
    public LoginFailHandler getLoginFailHandler() {
        return new LoginFailHandler();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/user/login") //过滤器拦截地址后跳转的地址
                .loginProcessingUrl("/user/form") //登录时表单发往的地址，经过的处理器postMapping，细节不需要写
                .successHandler(getLoginSuccessHandler())
                .failureHandler(getLoginFailHandler())
                .and()
                .csrf().disable() //使用jwt，不需要csrf
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //基于token，不需要session
                .and()
                .authorizeRequests()
                // 设置允许访问的资源
                .antMatchers("/user/login","/user/form").permitAll()
                // 设置允许访问的资源
                .antMatchers(
                        "/v2/api-docs",
                        "/swagger-resources",
                        "/swagger-resources/**",
                        "/configuration/ui",
                        "/configuration/security",
                        "/swagger-ui.html/**",
                        "/webjars/**",
                        "/index/**"
                ).permitAll()
                .anyRequest().authenticated();

        // 禁用缓存
        http.headers().cacheControl();

        // 添加JWT filter
        http.addFilterBefore(getauthenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
    }


}

