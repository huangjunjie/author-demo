package com.stone.demo.author.authorization.dao;

import com.stone.demo.author.authorization.bean.po.OauthRefreshToken;

public interface OauthRefreshTokenMapper {
    int insert(OauthRefreshToken record);

    int insertSelective(OauthRefreshToken record);
}