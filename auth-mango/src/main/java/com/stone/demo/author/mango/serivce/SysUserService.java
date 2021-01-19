package com.stone.demo.author.mango.serivce;

import com.stone.demo.author.mango.bean.po.SysUser;
import com.stone.demo.author.mango.bean.po.SysUserRole;
import com.stone.demo.author.mango.bean.vo.PageRequest;

import java.io.File;
import java.util.List;
import java.util.Set;

public interface SysUserService extends CrudService<SysUser>{

    SysUser findByName(String name);

    Set<String> findPermissions(String name);

    List<SysUserRole> findUserRoles(Long userId);

    File createUserExcelFile(PageRequest pageRequest);
}
