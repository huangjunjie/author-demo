package com.stone.demo.author.mango.dao;

import com.stone.demo.author.mango.bean.po.SysLoginLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysLoginLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysLoginLog record);

    int insertSelective(SysLoginLog record);

    SysLoginLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLoginLog record);

    int updateByPrimaryKey(SysLoginLog record);

    List<SysLoginLog> findPage();

    List<SysLoginLog> findPageByUserName(@Param("userName") String userName);

    List<SysLoginLog> findPageByStatus(@Param("status") String status);
}