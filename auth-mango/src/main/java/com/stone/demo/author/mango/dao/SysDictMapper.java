package com.stone.demo.author.mango.dao;

import com.stone.demo.author.mango.bean.po.SysDict;

import java.util.List;

public interface SysDictMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysDict record);

    int insertSelective(SysDict record);

    SysDict selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDict record);

    int updateByPrimaryKey(SysDict record);

    List<SysDict> findPage();
}