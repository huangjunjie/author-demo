package com.stone.demo.author.authorization.bean.po;

public class OauthCode {
    private String code;

    private String authentication;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication == null ? null : authentication.trim();
    }
}