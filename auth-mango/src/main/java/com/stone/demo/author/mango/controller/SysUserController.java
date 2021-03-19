package com.stone.demo.author.mango.controller;

import com.stone.demo.author.mango.bean.po.SysUser;
import com.stone.demo.author.mango.bean.vo.HttpResult;
import com.stone.demo.author.mango.bean.vo.PageRequest;
import com.stone.demo.author.mango.constants.SysConstants;
import com.stone.demo.author.mango.serivce.SysUserService;
import com.stone.demo.author.mango.utils.PasswordUtils;
import com.stone.demo.author.common.utils.FileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/***
 *
 * @Class SysUserController
 * @Descrip TODO
 * @author Stone
 * @data 21-1-18  上午11:22
 * @Version 1.0
 */

@Api(tags = "用户接口")
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation("查询用户信息")
    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysUserService.findPage(pageRequest));
    }

    @ApiOperation("保存用户信息")
    @PreAuthorize("hasAuthority('sys:user:add') AND hasAuthority('sys:user:edit')")
    @PostMapping("/save")
    public HttpResult save(@RequestBody SysUser record) {
        //设计思路
        SysUser sysUser = sysUserService.findById(record.getId());
        if(sysUser != null && SysConstants.ADMIN.equalsIgnoreCase(sysUser.getName())) {
            return HttpResult.error("超级管理员不允许修改");
        }
        if (record.getPassword() != null) {
            String salt = PasswordUtils.getSalt();
            if (null == sysUser) {
                // 新建用户
                if (!ObjectUtils.isEmpty(sysUserService.findByName(record.getName()))) {
                    return HttpResult.error("用户名已存在");
                }
                String password = PasswordUtils.encode(record.getPassword(),salt);
                record.setSalt(salt);
                record.setPassword(password);
            } else {
                // 修改密码
                if(!record.getPassword().equals(sysUser.getPassword())) {
                    String password = PasswordUtils.encode(record.getPassword(), salt);
                    record.setSalt(salt);
                    record.setPassword(password);
                }
            }
        }
        return HttpResult.ok(sysUserService.save(record));
    }

    @PreAuthorize("hasAuthority('sys:user:delete')")
    @PostMapping(value="/delete")
    public HttpResult delete(@RequestBody List<SysUser> records) {
        if(!ObjectUtils.isEmpty(records)) {
            return HttpResult.ok(sysUserService.delete(records));
        }
        return HttpResult.error("入参错误");
    }

    @PreAuthorize("hasAuthority('sys:user:view')")
    @GetMapping(value="/findByName")
    public HttpResult findByName(@RequestParam("name") String name) {
        if(!StringUtils.isEmpty(name)) {
            return HttpResult.ok(sysUserService.findByName(name) );
        } else {
            return HttpResult.error("入参错误");
        }
    }

    @PreAuthorize("hasAuthority('sys:user:view')")
    @GetMapping(value="/findPermissions")
    public HttpResult findPermissions(@RequestParam String name) {
        return HttpResult.ok(sysUserService.findPermissions(name));
    }

    @PreAuthorize("hasAuthority('sys:user:view')")
    @GetMapping(value="/findUserRoles")
    public HttpResult findUserRoles(@RequestParam Long userId) {
        return HttpResult.ok(sysUserService.findUserRoles(userId));
    }


    @PreAuthorize("hasAuthority('sys:user:view')")
    @PostMapping(value="/exportExcelUser")
    public void exportExcelUser(@RequestBody PageRequest pageRequest, HttpServletResponse res) {
        File file = sysUserService.createUserExcelFile(pageRequest);
        FileUtils.downloadFile(res, file, file.getName());
    }
}
