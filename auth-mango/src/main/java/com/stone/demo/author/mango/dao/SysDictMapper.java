package com.stone.demo.author.mango.dao;

import com.stone.demo.author.mango.bean.po.SysDict;
import com.stone.demo.author.mango.bean.po.SysDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDictMapper {
    int countByExample(SysDictExample example);

    int deleteByExample(SysDictExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysDict record);

    int insertSelective(SysDict record);

    List<SysDict> selectByExample(SysDictExample example);

    SysDict selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysDict record, @Param("example") SysDictExample example);

    int updateByExample(@Param("record") SysDict record, @Param("example") SysDictExample example);

    int updateByPrimaryKeySelective(SysDict record);

    int updateByPrimaryKey(SysDict record);
}