package com.stone.demo.author.mango.dao;

import com.stone.demo.author.mango.bean.po.SysLoginLog;
import com.stone.demo.author.mango.bean.po.SysLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLoginLogMapper {
    int countByExample(SysLoginLogExample example);

    int deleteByExample(SysLoginLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysLoginLog record);

    int insertSelective(SysLoginLog record);

    List<SysLoginLog> selectByExample(SysLoginLogExample example);

    SysLoginLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysLoginLog record, @Param("example") SysLoginLogExample example);

    int updateByExample(@Param("record") SysLoginLog record, @Param("example") SysLoginLogExample example);

    int updateByPrimaryKeySelective(SysLoginLog record);

    int updateByPrimaryKey(SysLoginLog record);
}