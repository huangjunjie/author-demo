package com.stone.demo.author.mango.serivce;

import com.stone.demo.author.mango.bean.po.SysDept;

import java.util.List;

public interface SysDeptService extends CrudService<SysDept>{

    /**
     * 查询机构树
     * @return
     */
    List<SysDept> findTree();
}
