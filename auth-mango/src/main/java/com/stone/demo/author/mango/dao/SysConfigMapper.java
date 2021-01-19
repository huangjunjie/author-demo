package com.stone.demo.author.mango.dao;

import com.stone.demo.author.mango.bean.po.SysConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysConfig record);

    int insertSelective(SysConfig record);

    SysConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysConfig record);

    int updateByPrimaryKey(SysConfig record);

    List<SysConfig> findByLabel(@Param("label") String label);

    List<SysConfig> findPageByLabel(@Param("label") String label);

    List<SysConfig> findPage();
}