package com.stone.demo.author.authorization.dao;

import com.stone.demo.author.authorization.bean.po.Clientdetails;

public interface ClientdetailsMapper {
    int deleteByPrimaryKey(String appid);

    int insert(Clientdetails record);

    int insertSelective(Clientdetails record);

    Clientdetails selectByPrimaryKey(String appid);

    int updateByPrimaryKeySelective(Clientdetails record);

    int updateByPrimaryKey(Clientdetails record);

}