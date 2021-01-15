package com.stone.demo.author.mango.serivce.impl;

import com.stone.demo.author.mango.bean.po.SysDept;
import com.stone.demo.author.mango.bean.vo.PageRequest;
import com.stone.demo.author.mango.bean.vo.PageResult;
import com.stone.demo.author.mango.dao.SysConfigMapper;
import com.stone.demo.author.mango.serivce.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 *
 * @Class SysDeptServiceImpl
 * @Descrip TODO
 * @author Stone
 * @data 21-1-15  下午6:44
 * @Version 1.0
 */
@Service
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    private SysConfigMapper sysConfigMapper;

    /**
     * 通用保存接口
     *
     * @param record
     * @return
     */
    @Override
    public int save(SysDept record) {
        return 0;
    }

    /***
     * 单点删除接口
     *
     * @param record
     * @return
     */
    @Override
    public int delete(SysDept record) {
        return 0;
    }

    /**
     * 批量删除接口
     *
     * @param records
     * @return
     */
    @Override
    public int delete(List<SysDept> records) {
        return 0;
    }

    /**
     * 通过id查看数据接口
     *
     * @param id
     * @return
     */
    @Override
    public SysDept findById(Long id) {
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
