package com.stone.demo.author.authorization.dao;

import com.stone.demo.author.authorization.bean.po.OauthClientToken;

public interface OauthClientTokenMapper {
    int deleteByPrimaryKey(String authenticationId);

    int insert(OauthClientToken record);

    int insertSelective(OauthClientToken record);

    OauthClientToken selectByPrimaryKey(String authenticationId);

    int updateByPrimaryKeySelective(OauthClientToken record);

    int updateByPrimaryKey(OauthClientToken record);
}