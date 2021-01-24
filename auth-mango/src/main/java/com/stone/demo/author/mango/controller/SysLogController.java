package com.stone.demo.author.mango.controller;

import com.stone.demo.author.mango.bean.po.SysLog;
import com.stone.demo.author.mango.bean.vo.HttpResult;
import com.stone.demo.author.mango.bean.vo.PageRequest;
import com.stone.demo.author.mango.serivce.SysLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 *
 * @Class SysLogController
 * @Descrip TODO
 * @author Stone
 * @data 21-1-18  上午11:21
 * @Version 1.0
 */
@Api(tags = "日志查找")
@RestController
@RequestMapping("log")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @ApiOperation("分页日志")
    @PreAuthorize("hasAuthority('sys:log:view')")
    @PostMapping(value="/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysLogService.findPage(pageRequest));
    }

    @ApiOperation("删除日志")
    @PreAuthorize("hasAuthority('sys:log:delete')")
    @PostMapping(value="/delete")
    public HttpResult delete(@RequestBody List<SysLog> records) {
        return HttpResult.ok(sysLogService.delete(records));
    }
}
