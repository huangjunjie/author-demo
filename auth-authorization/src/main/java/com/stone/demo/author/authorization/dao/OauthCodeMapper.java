package com.stone.demo.author.authorization.dao;

import com.stone.demo.author.authorization.bean.po.OauthCode;

public interface OauthCodeMapper {
    int insert(OauthCode record);

    int insertSelective(OauthCode record);
}