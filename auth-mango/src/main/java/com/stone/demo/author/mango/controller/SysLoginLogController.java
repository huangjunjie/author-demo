package com.stone.demo.author.mango.controller;

import com.stone.demo.author.mango.bean.po.SysLoginLog;
import com.stone.demo.author.mango.bean.vo.HttpResult;
import com.stone.demo.author.mango.bean.vo.PageRequest;
import com.stone.demo.author.mango.serivce.SysLoginLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 *
 * @Class SysLoginLogController
 * @Descrip TODO
 * @author Stone
 * @data 21-1-18  上午11:21
 * @Version 1.0
 */
@Api(tags = "登入日志")
@RestController
@RequestMapping("loginLog")
public class SysLoginLogController {

    @Autowired
    private SysLoginLogService sysLoginLogService;

    @ApiOperation("分页登入日志")
    @PostMapping(value="/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysLoginLogService.findPage(pageRequest));
    }

    @ApiOperation("删除登入日志")
    @PostMapping(value="/delete")
    public HttpResult delete(@RequestBody List<SysLoginLog> records) {
        return HttpResult.ok(sysLoginLogService.delete(records));
    }
}
