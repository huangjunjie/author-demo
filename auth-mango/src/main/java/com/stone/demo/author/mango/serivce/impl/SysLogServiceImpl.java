package com.stone.demo.author.mango.serivce.impl;

import com.stone.demo.author.mango.bean.po.SysLog;
import com.stone.demo.author.mango.bean.vo.PageRequest;
import com.stone.demo.author.mango.bean.vo.PageResult;
import com.stone.demo.author.mango.constants.SysConstants;
import com.stone.demo.author.mango.dao.SysLogMapper;
import com.stone.demo.author.mango.serivce.SysLogService;
import com.stone.demo.author.mango.utils.MybatisPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        if(record.getId() == null || record.getId() == 0) {
            return sysLogMapper.insertSelective(record);
        }
        return sysLogMapper.updateByPrimaryKeySelective(record);
    }

    /***
     * 单点删除接口
     *
     * @param record
     * @return
     */
    @Override
    public int delete(SysLog record) {
        return sysLogMapper.deleteByPrimaryKey(record.getId());
    }

    /**
     * 批量删除接口
     *
     * @param records
     * @return
     */
    @Override
    public int delete(List<SysLog> records) {
        for(SysLog record:records) {
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
    public SysLog findById(Long id) {
        return sysLogMapper.selectByPrimaryKey(id);
    }

    /**
     * 查看分页接口
     *
     * @param request
     * @return
     */
    @Override
    public PageResult findPage(PageRequest request) {
        Optional label = request.getParams("userName");
        if(label.isPresent()) {
            return MybatisPageHelper.findPage(request, sysLogMapper, "findPageByUserName", label);
        }
        return MybatisPageHelper.findPage(request, sysLogMapper);
    }
}
