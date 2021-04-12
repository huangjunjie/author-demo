package com.stone.demo.author.mango.security;

import com.stone.demo.author.mango.utils.SecurityUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 *
 * @Class JwtAuthenticationFilter
 * @Descrip TODO
 * @author Stone
 * @data 21-1-24  上午12:58
 * @Version 1.0
 */

public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    private Integer tokenExpireTime;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, Integer tokenExpireTime) {
        super(authenticationManager);
        this.tokenExpireTime = tokenExpireTime;
    }

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
        super(authenticationManager, authenticationEntryPoint);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 获取token, 并检查登录状态
        SecurityUtils.checkAuthentication(request);
        chain.doFilter(request, response);

    }

}
