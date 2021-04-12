package com.stone.demo.author.mango.dao;

import com.stone.demo.author.mango.bean.po.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser findByName(String name);

    List<SysUser> findPage();

    List<SysUser> findPageByNameAndEmail(@Param("name")String name, @Param("email")String email);

    List<SysUser> findPageByName(@Param("name")String name);

}