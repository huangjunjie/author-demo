package com.stone.demo.author.mango.serivce.impl;

import com.stone.demo.author.mango.bean.po.SysConfig;
import com.stone.demo.author.mango.bean.vo.PageRequest;
import com.stone.demo.author.mango.bean.vo.PageResult;
import com.stone.demo.author.mango.constants.SysConstants;
import com.stone.demo.author.mango.dao.SysConfigMapper;
import com.stone.demo.author.mango.serivce.SysConfigService;
import com.stone.demo.author.mango.utils.MybatisPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

/***
 *
 * @Class SysConfigServiceImpl
 * @Descrip TODO
 * @author Stone
 * @data 21-1-15  下午6:43
 * @Version 1.0
 */
@Service
public class SysConfigServiceImpl implements SysConfigService {


    @Autowired
    private SysConfigMapper sysConfigMapper;

    /**
     * 通用保存接口
     *
     * @param record
     * @return
     */
    @Override
    public int save(SysConfig record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysConfigMapper.insert(record);
        } else {
            return sysConfigMapper.updateByPrimaryKey(record);
        }
    }

    /***
     * 单点删除接口
     *
     * @param record
     * @return
     */
    @Override
    public int delete(SysConfig record) {
        if (record != null && record.getId() != null) {
            return sysConfigMapper.deleteByPrimaryKey(record.getId());
        }
        return SysConstants.FAIL_RETURN;
    }

    /**
     * 批量删除接口
     *
     * @param records
     * @return
     */
    @Override
    public int delete(List<SysConfig> records) {
        if (!ObjectUtils.isEmpty(records)) {
            for (SysConfig record : records) {
                delete(record);
            }
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
    public SysConfig findById(Long id) {
        return sysConfigMapper.selectByPrimaryKey(id);
    }

    /**
     * 查看分页接口
     *
     * @param request
     * @return
     */
    @Override
    public PageResult findPage(PageRequest request) {
        Optional label = request.getParams("label");
        if(label.isPresent()) {
            return MybatisPageHelper.findPage(request, sysConfigMapper, "findPageByLabel", label);
        }
        return MybatisPageHelper.findPage(request,sysConfigMapper);
    }

    @Override
    public List<SysConfig> findByLabel(String label) {
        return sysConfigMapper.findByLabel(label);
    }

}
