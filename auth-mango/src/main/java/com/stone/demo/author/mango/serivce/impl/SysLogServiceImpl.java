package com.stone.demo.author.mango.serivce.impl;

import com.stone.demo.author.mango.bean.po.SysLog;
import com.stone.demo.author.mango.bean.vo.PageRequest;
import com.stone.demo.author.mango.bean.vo.PageResult;
import com.stone.demo.author.mango.dao.SysLogMapper;
import com.stone.demo.author.mango.serivce.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 *
 * @Class SysLogServiceImpl
 * @Descrip TODO
 * @author Stone
 * @data 21-1-15  下午6:44
 * @Version 1.0
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    /**
     * 通用保存接口
     *
     * @param record
     * @return
     */
    @Override
    public int save(SysLog record) {
        return 0;
    }

    /***
     * 单点删除接口
     *
     * @param record
     * @return
     */
    @Override
    public int delete(SysLog record) {
        return 0;
    }

    /**
     * 批量删除接口
     *
     * @param records
     * @return
     */
    @Override
    public int delete(List<SysLog> records) {
        return 0;
    }

    /**
     * 通过id查看数据接口
     *
     * @param id
     * @return
     */
    @Override
    public SysLog findById(Long id) {
        return null;
    }

    /**
     * 查看分页接口
     *
     * @param request
     * @return
     */
    @Override
    public PageResult findPage(PageRequest request) {
        return null;
    }
}
