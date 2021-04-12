package com.stone.demo.author.mango.serivce.impl;

import com.stone.demo.author.mango.bean.po.SysLoginLog;
import com.stone.demo.author.mango.bean.vo.PageRequest;
import com.stone.demo.author.mango.bean.vo.PageResult;
import com.stone.demo.author.mango.constants.SysConstants;
import com.stone.demo.author.mango.dao.SysLoginLogMapper;
import com.stone.demo.author.mango.serivce.SysLoginLogService;
import com.stone.demo.author.mango.utils.MybatisPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/***
 *
 * @Class SysLoginLogServiceImpl
 * @Descrip TODO
 * @author Stone
 * @data 21-1-15  下午6:44
 * @Version 1.0
 */
@Service
public class SysLoginLogServiceImpl implements SysLoginLogService {

    @Autowired
    private SysLoginLogMapper sysLoginLogMapper;

    /**
     * 通用保存接口
     *
     * @param record
     * @return
     */
    @Override
    public int save(SysLoginLog record) {
        if(record.getId() == null || record.getId() == 0) {
            return sysLoginLogMapper.insertSelective(record);
        }
        return sysLoginLogMapper.updateByPrimaryKeySelective(record);
    }

    /***
     * 单点删除接口
     *
     * @param record
     * @return
     */
    @Override
    public int delete(SysLoginLog record) {
        return sysLoginLogMapper.deleteByPrimaryKey(record.getId());
    }

    /**
     * 批量删除接口
     *
     * @param records
     * @return
     */
    @Override
    public int delete(List<SysLoginLog> records) {
        for(SysLoginLog record:records) {
            delete(record);
        }
        return SysConstants.SUCCESS_RETURN;
    }

    /**
     * 通过id查看数据接口
     *
     * @param id
     * @return
     */
    @Override
    public SysLoginLog findById(Long id) {
        return sysLoginLogMapper.selectByPrimaryKey(id);
    }

    /**
     * 查看分页接口
     *
     * @param request
     * @return
     */
    @Override
    public PageResult findPage(PageRequest request) {
        Optional userName = request.getParams("userName");
        if(userName.isPresent()) {
            return MybatisPageHelper.findPage(request, sysLoginLogMapper, "findPageByUserName", userName.get());
        }
        Optional status = request.getParams("status");
        if(status.isPresent()) {
            return MybatisPageHelper.findPage(request, sysLoginLogMapper, "findPageByStatus", status.get());
        }
        return MybatisPageHelper.findPage(request, sysLoginLogMapper);
    }
}
