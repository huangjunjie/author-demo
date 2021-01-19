package com.stone.demo.author.mango.dao;

import com.stone.demo.author.mango.bean.po.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);

    List<SysUserRole> findPage();

    int deleteByUserId(Long id);

    List<SysUserRole> findUserRoles(@Param("userId")Long userId);
}