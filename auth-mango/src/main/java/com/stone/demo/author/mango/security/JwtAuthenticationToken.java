package com.stone.demo.author.mango.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/***
 *
 * @Class JwtAuthenticationToken
 * @Descrip 顶级包装类使用Token 等同于 Authencation 可以直接放入 SecurityContextHolder
 *          + principal   ==> UserDetails  @see{JwtUserDetails}
 *          + credentails ==> 登入凭证 等价于 加密过的密码
 *          + authorities ==> 授权集合
 * @author Stone
 * @data 21-1-24  上午1:52
 * @Version 1.0
 */
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private String token;

    public JwtAuthenticationToken(Object principal, Object credentials){
        super(principal, credentials);
    }

    public JwtAuthenticationToken(Object principal, Object credentials, String token){
        super(principal, credentials);
        this.token = token;
    }

    public JwtAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, String token) {
        super(principal, credentials, authorities);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
