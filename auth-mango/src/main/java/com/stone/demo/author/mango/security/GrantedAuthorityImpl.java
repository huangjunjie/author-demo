package com.stone.demo.author.mango.security;

import org.springframework.security.core.GrantedAuthority;

/***
 *
 * @Class GrantedAuthorityImpl
 * @Descrip 授权集合
 * @author Stone
 * @data 21-1-24  上午1:53
 * @Version 1.0
 */
public class GrantedAuthorityImpl implements GrantedAuthority {

    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
