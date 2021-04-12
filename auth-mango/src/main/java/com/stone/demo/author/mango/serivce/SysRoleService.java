package com.stone.demo.author.mango.serivce;

import com.stone.demo.author.mango.bean.po.SysMenu;
import com.stone.demo.author.mango.bean.po.SysRole;
import com.stone.demo.author.mango.bean.po.SysRoleMenu;

import java.util.List;

public interface SysRoleService extends CrudService<SysRole>{


    /**
     * 查询全部
     * @return
     */
    List<SysRole> findAll();

    /**
     * 查询角色菜单集合
     * @return
     */
    List<SysMenu> findRoleMenus(Long roleId);

    /**
     * 保存角色菜单
     * @param records
     * @return
     */
    int saveRoleMenus(List<SysRoleMenu> records);

    /**
     * 根据名称查询
     * @param name
     * @return
     */
    List<SysRole> findByName(String name);
}
