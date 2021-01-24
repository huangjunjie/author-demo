package com.stone.demo.author.mango.controller;

import com.stone.demo.author.mango.bean.po.SysConfig;
import com.stone.demo.author.mango.bean.vo.HttpResult;
import com.stone.demo.author.mango.bean.vo.PageRequest;
import com.stone.demo.author.mango.serivce.SysConfigService;
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
 * @Class SysConfigController
 * @Descrip TODO
 * @author Stone
 * @data 21-1-18  上午11:20
 * @Version 1.0
 */
@Api(tags = "配置")
@RestController
@RequestMapping("config")
public class SysConfigController {

    @Autowired
    private SysConfigService sysConfigService;

    @ApiOperation("配置保存接口")
    @PreAuthorize("hasAuthority('sys:config:add') AND hasAuthority('sys:config:edit')")
    @PostMapping(value="/save")
    public HttpResult save(@RequestBody SysConfig record) {
        return HttpResult.ok(sysConfigService.save(record));
    }

    @ApiOperation("配置删除接口")
    @PreAuthorize("hasAuthority('sys:config:delete')")
    @PostMapping(value="/delete")
    public HttpResult delete(@RequestBody List<SysConfig> records) {
        return HttpResult.ok(sysConfigService.delete(records));
    }

    @ApiOperation("配置查找接口")
    @PreAuthorize("hasAuthority('sys:config:view')")
    @PostMapping(value="/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysConfigService.findPage(pageRequest));
    }

    @ApiOperation("配置查找标签接口")
    @PreAuthorize("hasAuthority('sys:config:view')")
    @GetMapping(value="/findByLable")
    public HttpResult findByLable(@RequestParam("label") String label) {
        return HttpResult.ok(sysConfigService.findByLabel(label));
    }
}
