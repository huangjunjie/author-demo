package com.stone.demo.author.authorization.dao;

import com.stone.demo.author.authorization.bean.po.OauthAccessToken;

public interface OauthAccessTokenMapper {
    int deleteByPrimaryKey(String authenticationId);

    int insert(OauthAccessToken record);

    int insertSelective(OauthAccessToken record);

    OauthAccessToken selectByPrimaryKey(String authenticationId);

    int updateByPrimaryKeySelective(OauthAccessToken record);

    int updateByPrimaryKey(OauthAccessToken record);
}