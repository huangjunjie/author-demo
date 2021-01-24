package com.stone.demo.author.mango.controller;

import com.stone.demo.author.mango.bean.po.SysDept;
import com.stone.demo.author.mango.bean.vo.HttpResult;
import com.stone.demo.author.mango.serivce.SysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 *
 * @Class SysDeptController
 * @Descrip  机构控制器
 * @author Stone
 * @data 21-1-18  上午11:20
 * @Version 1.0
 */
@Api(tags = "部门接口")
@RestController
@RequestMapping("dept")
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    @ApiOperation("部门保存接口")
    @PostMapping(value="/save")
    @PreAuthorize("hasAuthority('sys:dept:add') AND hasAuthority('sys:dept:edit')")
    public HttpResult save(@RequestBody SysDept record) {
        return HttpResult.ok(sysDeptService.save(record));
    }

    @ApiOperation("部门删除接口")
    @PreAuthorize("hasAuthority('sys:dept:delete')")
    @PostMapping(value="/delete")
    public HttpResult delete(@RequestBody List<SysDept> records) {
        return HttpResult.ok(sysDeptService.delete(records));
    }

    @ApiOperation("查询机构树")
    @PreAuthorize("hasAuthority('sys:dept:view')")
    @GetMapping(value="/findTree")
    public HttpResult findTree() {
        return HttpResult.ok(sysDeptService.findTree());
    }
}
