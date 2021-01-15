package com.stone.demo.author.mango.dao;

import com.stone.demo.author.mango.bean.po.SysRoleDept;
import com.stone.demo.author.mango.bean.po.SysRoleDeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleDeptMapper {
    int countByExample(SysRoleDeptExample example);

    int deleteByExample(SysRoleDeptExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysRoleDept record);

    int insertSelective(SysRoleDept record);

    List<SysRoleDept> selectByExample(SysRoleDeptExample example);

    SysRoleDept selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysRoleDept record, @Param("example") SysRoleDeptExample example);

    int updateByExample(@Param("record") SysRoleDept record, @Param("example") SysRoleDeptExample example);

    int updateByPrimaryKeySelective(SysRoleDept record);

    int updateByPrimaryKey(SysRoleDept record);
}