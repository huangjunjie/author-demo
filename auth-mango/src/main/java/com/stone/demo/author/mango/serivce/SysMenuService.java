package com.stone.demo.author.mango.serivce;

import com.stone.demo.author.mango.bean.po.SysMenu;

import java.util.List;

public interface SysMenuService extends CrudService<SysMenu>{

    /**
     * 查询菜单树,用户ID和用户名为空则查询全部
     * @param menuType 获取菜单类型，0：获取所有菜单，包含按钮，1：获取所有菜单，不包含按钮
     * @param userName
     * @return
     */
    List<SysMenu> findTree(String userName, Integer menuType);

    /**
     * 根据用户名查找菜单列表
     * @param userName
     * @return
     */
    List<SysMenu> findByUser(String userName);
}
