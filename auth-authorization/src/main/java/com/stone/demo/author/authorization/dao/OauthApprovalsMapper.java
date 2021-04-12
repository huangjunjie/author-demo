package com.stone.demo.author.authorization.dao;

import com.stone.demo.author.authorization.bean.po.OauthApprovals;

public interface OauthApprovalsMapper {
    int insert(OauthApprovals record);

    int insertSelective(OauthApprovals record);
}