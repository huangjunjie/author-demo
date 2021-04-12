package com.stone.demo.author.mango.serivce.impl;

import com.stone.demo.author.mango.bean.po.SysDept;
import com.stone.demo.author.mango.bean.vo.PageRequest;
import com.stone.demo.author.mango.bean.vo.PageResult;
import com.stone.demo.author.mango.constants.SysConstants;
import com.stone.demo.author.mango.dao.SysDeptMapper;
import com.stone.demo.author.mango.serivce.SysDeptService;
import com.stone.demo.author.mango.utils.MybatisPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    private SysDeptMapper sysDeptMapper;

    private static SysDept apply(SysDept item) {
        item.setLevel(0);
        return item;
    }

    /**
     * 通用保存接口
     *
     * @param record
     * @return
     */
    @Override
    public int save(SysDept record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysDeptMapper.insertSelective(record);
        }
        return sysDeptMapper.updateByPrimaryKeySelective(record);
    }

    /***
     * 单点删除接口
     *
     * @param record
     * @return
     */
    @Override
    public int delete(SysDept record) {
        return sysDeptMapper.deleteByPrimaryKey(record.getId());
    }

    /**
     * 批量删除接口
     *
     * @param records
     * @return
     */
    @Override
    public int delete(List<SysDept> records) {
        for (SysDept record : records) {
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
    public SysDept findById(Long id) {
        return sysDeptMapper.selectByPrimaryKey(id);
    }

    /**
     * 查看分页接口
     *
     * @param request
     * @return
     */
    @Override
    public PageResult findPage(PageRequest request) {
        return MybatisPageHelper.findPage(request, sysDeptMapper);
    }

    /**
     * 查询机构树
     *
     * @return
     */
    @Override
    public List<SysDept> findTree() {
        List<SysDept> sysDepts = sysDeptMapper.findAll();
        List<SysDept> root =
                Optional.of(sysDepts
                        .stream()
                        .filter(item -> item.getParentId() == null || item.getParentId() == 0)
                        .map(SysDeptServiceImpl::apply)
                        .collect(Collectors.toList()))
                        .orElse(new ArrayList<>());
        findChildren(root,sysDepts);
        return root;
    }

    /**
     *
     * @Author: stone
     * @Description:  查询机构树
     * @DateTime: 21-1-18 下午2:19
     * @Params: 
     * @Return 
     */
    private void findChildren(List<SysDept> parentDept, List<SysDept> deptData) {
        for (SysDept item : parentDept) {
            List<SysDept> children = new ArrayList<>();
            for (SysDept dept : deptData) {
                if (item.getId() != null && item.getId().equals(dept.getParentId())) {
                    dept.setParentName(dept.getName());
                    dept.setLevel(item.getLevel() + 1);
                    children.add(dept);
                }
            }
            item.setChildren(children);
            findChildren(children, deptData);
        }
    }
}
