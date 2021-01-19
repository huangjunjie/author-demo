package com.stone.demo.author.mango.controller;

import com.stone.demo.author.mango.bean.po.SysDict;
import com.stone.demo.author.mango.bean.vo.HttpResult;
import com.stone.demo.author.mango.bean.vo.PageRequest;
import com.stone.demo.author.mango.serivce.SysDictService;
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
 * @Class SysDictController
 * @Descrip TODO
 * @author Stone
 * @data 21-1-18  上午11:21
 * @Version 1.0
 */
@Api(tags = "查找字典集")
@RestController
@RequestMapping("dict")
public class SysDictController {

    @Autowired
    private SysDictService sysDictService;

    @ApiOperation("字典集保存")
    @PostMapping(value="/save")
    public HttpResult save(@RequestBody SysDict record) {
        return HttpResult.ok(sysDictService.save(record));
    }

    @ApiOperation("字典集保存")
    @PostMapping(value="/delete")
    public HttpResult delete(@RequestBody List<SysDict> records) {
        return HttpResult.ok(sysDictService.delete(records));
    }

    @ApiOperation("字典集分页查找")
    @PostMapping(value="/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysDictService.findPage(pageRequest));
    }

    @ApiOperation("标签查找字典集")
    @GetMapping(value="/findByLabel")
    public HttpResult findByLabel(@RequestParam String label) {
        return HttpResult.ok(sysDictService.findByLabel(label));
    }
}
