package com.stone.demo.author.mango.controller;

import com.stone.demo.author.mango.bean.po.SysMenu;
import com.stone.demo.author.mango.bean.vo.HttpResult;
import com.stone.demo.author.mango.serivce.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 *
 * @Class SysMenuController
 * @Descrip TODO
 * @author Stone
 * @data 21-1-18  上午11:21
 * @Version 1.0
 */
@Api(tags = "菜单")
@RestController
@RequestMapping("menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation("菜单保存接口")
    @PreAuthorize("hasAuthority('sys:menu:add') AND hasAuthority('sys:menu:edit')")
    @PostMapping(value="/save")
    public HttpResult save(@RequestBody SysMenu record) {
        return HttpResult.ok(sysMenuService.save(record));
    }

    @ApiOperation("菜单删除接口")
    @PreAuthorize("hasAuthority('sys:menu:delete')")
    @PostMapping(value="/delete")
    public HttpResult delete(@RequestBody List<SysMenu> records) {
        return HttpResult.ok(sysMenuService.delete(records));
    }

    @ApiOperation("菜单侧边栏查询接口")
    @PreAuthorize("hasAuthority('sys:menu:view')")
    @GetMapping(value="/findNavTree")
    public HttpResult findNavTree(@RequestParam String userName) {
        return HttpResult.ok(sysMenuService.findTree(userName, 1));
    }

    @ApiOperation("菜单树查询")
    @PreAuthorize("hasAuthority('sys:menu:view')")
    @GetMapping(value="/findMenuTree")
    public HttpResult findMenuTree() {
        return HttpResult.ok(sysMenuService.findTree(null, 0));
    }
}
