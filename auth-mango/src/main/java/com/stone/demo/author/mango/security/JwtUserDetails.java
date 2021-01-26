package com.stone.demo.author.mango.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/***
 *
 * @Class JwtUserDetails
 * @Descrip 用户数据具体保存位置
 *          用户自定义
 *          + authorities 授权 @see{GrantedAuthorityImpl}
 *          + password    密码
 *          + username    用户
 * @author Stone
 * @data 21-1-24  上午1:58
 * @Version 1.0
 */
public class JwtUserDetails implements UserDetails {

    private String username;

    private String password;

    private String salt;

    private Collection<? extends GrantedAuthority> authorities;

    JwtUserDetails(String username, String password, String salt, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.authorities = authorities;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
