package com.stone.demo.author.mango.dao;

import com.stone.demo.author.mango.bean.po.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> findPage();

    List<SysMenu> findPageByName(@Param("name")String name);

    List<SysMenu> findAll();

    List<SysMenu> findByUserName(@Param("userName")String userName);

    List<SysMenu> findRoleMenus(@Param("roleId")Long roleId);
}