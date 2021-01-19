package com.stone.demo.author.mango.serivce.impl;

import com.stone.demo.author.mango.bean.po.SysMenu;
import com.stone.demo.author.mango.bean.po.SysRole;
import com.stone.demo.author.mango.bean.po.SysUser;
import com.stone.demo.author.mango.bean.po.SysUserRole;
import com.stone.demo.author.mango.bean.vo.PageRequest;
import com.stone.demo.author.mango.bean.vo.PageResult;
import com.stone.demo.author.mango.constants.SysConstants;
import com.stone.demo.author.mango.dao.SysMenuMapper;
import com.stone.demo.author.mango.dao.SysRoleMapper;
import com.stone.demo.author.mango.dao.SysRoleMenuMapper;
import com.stone.demo.author.mango.dao.SysUserMapper;
import com.stone.demo.author.mango.dao.SysUserRoleMapper;
import com.stone.demo.author.mango.serivce.SysMenuService;
import com.stone.demo.author.mango.serivce.SysUserService;
import com.stone.demo.author.mango.utils.MybatisPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/***
 *
 * @Class SysUserServiceImpl
 * @Descrip TODO
 * @author Stone
 * @data 21-1-15  下午6:45
 * @Version 1.0
 */
@Service
public class SysUserServiceImpl implements SysUserService {



    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysMenuService sysMenuService;


    /**
     * 通用保存接口
     *
     * @param record
     * @return
     */
    @Override
    public int save(SysUser record) {
        Long id = null;
        if (record.getId() == null || record.getId() == 0) {
            // 新增用户
            sysUserMapper.insertSelective(record);
            id = record.getId();
        } else {
            // 更新用户信息
            sysUserMapper.updateByPrimaryKeySelective(record);
        }
        // 更新用户角色
        if (id != null && id == 0) {
            return SysConstants.SUCCESS_RETURN;
        }
        if (id != null) {
            for (SysUserRole sysUserRole : record.getUserRoles()) {
                sysUserRole.setUserId(id);
            }
        } else {
            sysUserRoleMapper.deleteByUserId(record.getId());
        }

        for (SysUserRole sysUserRole : record.getUserRoles()) {
            sysUserRoleMapper.insertSelective(sysUserRole);
        }
        return SysConstants.SUCCESS_RETURN;
    }

    /***
     * 单点删除接口
     *
     * @param record
     * @return
     */
    @Override
    public int delete(SysUser record) {
        if (!SysConstants.ADMIN.equalsIgnoreCase(record.getName())) {
            return sysUserMapper.deleteByPrimaryKey(record.getId());
        } else {
            throw new IllegalArgumentException("超级管理员不允许修改");
        }
    }

    /**
     * 批量删除接口
     *
     * @param records
     * @return
     */
    @Override
    public int delete(List<SysUser> records) {
        if (!ObjectUtils.isEmpty(records)) {
            for (SysUser record : records) {
                delete(record);
            }
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
    public SysUser findById(Long id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 查看分页接口
     *
     * @param request
     * @return
     */
    @Override
    public PageResult findPage(PageRequest request) {
        PageResult pageResult = null;
        Optional name = request.getParams("name");
        Optional email = request.getParams("email");
        if(name.isPresent()) {
            if(email.isPresent()) {
                pageResult = MybatisPageHelper.findPage(request, sysUserMapper, "findPageByNameAndEmail", name, email);
            } else {
                pageResult = MybatisPageHelper.findPage(request, sysUserMapper, "findPageByName", name);
            }
        } else {
            pageResult = MybatisPageHelper.findPage(request, sysUserMapper);
        }
        // 加载用户角色信息
        findUserRoles(pageResult);
        return pageResult;
    }

    /**
     * 加载用户角色
     * @param pageResult
     */
    private void findUserRoles(PageResult pageResult) {
        List<?> content = pageResult.getContent();
        for(Object object:content) {
            SysUser sysUser = (SysUser) object;
            List<SysUserRole> userRoles = findUserRoles(sysUser.getId());
            sysUser.setUserRoles(userRoles);
            sysUser.setRoleNames(getRoleNames(userRoles));
        }
    }


    private String getRoleNames(List<SysUserRole> userRoles) {
        StringBuilder sb = new StringBuilder();
        for(Iterator<SysUserRole> iter = userRoles.iterator(); iter.hasNext();) {
            SysUserRole userRole = iter.next();
            SysRole sysRole = sysRoleMapper.selectByPrimaryKey(userRole.getRoleId());
            if(sysRole == null) {
                continue ;
            }
            sb.append(sysRole.getRemark());
            if(iter.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    @Override
    public SysUser findByName(String name) {
        return sysUserMapper.findByName(name);
    }

    @Override
    public Set<String> findPermissions(String name) {
        Set<String> perms = new HashSet<>();
        List<SysMenu> sysMenus = sysMenuService.findByUser(name);
        for(SysMenu sysMenu:sysMenus) {
            if(sysMenu.getPerms() != null && !"".equals(sysMenu.getPerms())) {
                perms.add(sysMenu.getPerms());
            }
        }
        return perms;
    }

    @Override
    public List<SysUserRole> findUserRoles(Long userId) {
        return sysUserRoleMapper.findUserRoles(userId);
    }

    @Override
    public File createUserExcelFile(PageRequest pageRequest) {
        return null;
    }
}
