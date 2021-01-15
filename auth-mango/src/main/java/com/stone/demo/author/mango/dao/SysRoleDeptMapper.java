package com.stone.demo.author.mango.dao;

import com.stone.demo.author.mango.bean.po.SysRoleDept;

import java.util.List;

public interface SysRoleDeptMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleDept record);

    int insertSelective(SysRoleDept record);

    SysRoleDept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleDept record);

    int updateByPrimaryKey(SysRoleDept record);

    List<SysRoleDept> findPage();
}