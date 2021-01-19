package com.stone.demo.author.mango.controller;

import com.stone.demo.author.mango.bean.po.SysRole;
import com.stone.demo.author.mango.bean.po.SysRoleMenu;
import com.stone.demo.author.mango.bean.vo.HttpResult;
import com.stone.demo.author.mango.bean.vo.PageRequest;
import com.stone.demo.author.mango.constants.SysConstants;
import com.stone.demo.author.mango.dao.SysRoleMapper;
import com.stone.demo.author.mango.serivce.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 *
 * @Class SysRoleController
 * @Descrip TODO
 * @author Stone
 * @data 21-1-18  上午11:21
 * @Version 1.0
 */
@Api(tags = "角色接口")
@RestController
@RequestMapping("role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @ApiOperation("角色保存接口")
    @PostMapping(value="/save")
    public HttpResult save(@RequestBody SysRole record) {
        SysRole role = sysRoleService.findById(record.getId());
        if(role != null) {
            if(SysConstants.ADMIN.equalsIgnoreCase(role.getName())) {
                return HttpResult.error("超级管理员不允许修改!");
            }
        }
        // 新增角色
        if((record.getId() == null || record.getId() ==0) && !sysRoleService.findByName(record.getName()).isEmpty()) {
            return HttpResult.error("角色名已存在!");
        }
        return HttpResult.ok(sysRoleService.save(record));
    }

    @ApiOperation("角色删除接口")
    @PostMapping(value="/delete")
    public HttpResult delete(@RequestBody List<SysRole> records) {
        return HttpResult.ok(sysRoleService.delete(records));
    }

    @ApiOperation("角色分页接口")
    @PostMapping(value="/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysRoleService.findPage(pageRequest));
    }

    @ApiOperation("查询所有角色")
    @GetMapping(value="/findAll")
    public HttpResult findAll() {
        return HttpResult.ok(sysRoleService.findAll());
    }

    @ApiOperation("查询角色相关菜单")
    @GetMapping(value="/findRoleMenus")
    public HttpResult findRoleMenus(@RequestParam Long roleId) {
        return HttpResult.ok(sysRoleService.findRoleMenus(roleId));
    }

    @ApiOperation("保存角色菜单接口")
    @PostMapping(value="/saveRoleMenus")
    public HttpResult saveRoleMenus(@RequestBody List<SysRoleMenu> records) {
        for(SysRoleMenu record:records) {
            SysRole sysRole = sysRoleMapper.selectByPrimaryKey(record.getRoleId());
            if(SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())) {
                // 如果是超级管理员，不允许修改
                return HttpResult.error("超级管理员拥有所有菜单权限，不允许修改！");
            }
        }
        return HttpResult.ok(sysRoleService.saveRoleMenus(records));
    }
}
