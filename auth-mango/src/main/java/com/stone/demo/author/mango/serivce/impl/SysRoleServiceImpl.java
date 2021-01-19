package com.stone.demo.author.mango.serivce.impl;

import com.stone.demo.author.mango.bean.po.SysMenu;
import com.stone.demo.author.mango.bean.po.SysRole;
import com.stone.demo.author.mango.bean.po.SysRoleMenu;
import com.stone.demo.author.mango.bean.vo.PageRequest;
import com.stone.demo.author.mango.bean.vo.PageResult;
import com.stone.demo.author.mango.constants.SysConstants;
import com.stone.demo.author.mango.dao.SysMenuMapper;
import com.stone.demo.author.mango.dao.SysRoleMapper;
import com.stone.demo.author.mango.dao.SysRoleMenuMapper;
import com.stone.demo.author.mango.serivce.SysRoleService;
import com.stone.demo.author.mango.utils.MybatisPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/***
 *
 * @Class SysRoleServiceImpl
 * @Descrip TODO
 * @author Stone
 * @data 21-1-15  下午6:45
 * @Version 1.0
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * 通用保存接口
     *
     * @param record
     * @return
     */
    @Override
    public int save(SysRole record) {
        if(record.getId() == null || record.getId() == 0) {
            return sysRoleMapper.insertSelective(record);
        }
        return sysRoleMapper.updateByPrimaryKeySelective(record);
    }

    /***
     * 单点删除接口
     *
     * @param record
     * @return
     */
    @Override
    public int delete(SysRole record) {
        return sysRoleMapper.deleteByPrimaryKey(record.getId());
    }

    /**
     * 批量删除接口
     *
     * @param records
     * @return
     */
    @Override
    public int delete(List<SysRole> records) {
        for(SysRole record:records) {
            delete(record);
        }
        return SysConstants.SUCCESS_RETURN;
    }

    /**
     * 通过id查看数据接口
     *
     * @param id
     * @return
     */
    @Override
    public SysRole findById(Long id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    /**
     * 查看分页接口
     *
     * @param request
     * @return
     */
    @Override
    public PageResult findPage(PageRequest request) {
        Optional label = request.getParams("name");
        if(label .isPresent()) {
            return MybatisPageHelper.findPage(request, sysRoleMapper, "findPageByName", label.get());
        }
        return MybatisPageHelper.findPage(request, sysRoleMapper);
    }

    /**
     * 查询全部
     *
     * @return
     */
    @Override
    public List<SysRole> findAll() {
        return sysRoleMapper.findAll();
    }



    /**
     * 查询角色菜单集合
     *
     * @param roleId
     * @return
     */
    @Override
    public List<SysMenu> findRoleMenus(Long roleId) {
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleId);
        if(SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())) {
            // 如果是超级管理员，返回全部
            return sysMenuMapper.findAll();
        }
        return sysMenuMapper.findRoleMenus(roleId);
    }

    /**
     * 保存角色菜单
     *
     * @param records
     * @return
     */
    @Override
    public int saveRoleMenus(List<SysRoleMenu> records) {
        if(records == null || records.isEmpty()) {
            return SysConstants.SUCCESS_RETURN;
        }
        Long roleId = records.get(0).getRoleId();
        sysRoleMenuMapper.deleteByRoleId(roleId);
        for(SysRoleMenu record:records) {
            sysRoleMenuMapper.insertSelective(record);
        }
        return SysConstants.SUCCESS_RETURN;
    }

    /**
     * 根据名称查询
     *
     * @param name
     * @return
     */
    @Override
    public List<SysRole> findByName(String name) {
        return sysRoleMapper.findByName(name);
    }
}
