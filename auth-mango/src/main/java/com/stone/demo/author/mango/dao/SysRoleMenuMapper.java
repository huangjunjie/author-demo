package com.stone.demo.author.mango.dao;

import com.stone.demo.author.mango.bean.po.SysRoleMenu;

import java.util.List;

public interface SysRoleMenuMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    SysRoleMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleMenu record);

    int updateByPrimaryKey(SysRoleMenu record);

    List<SysRoleMenu> findPage();

    int deleteByRoleId(Long roleId);
}