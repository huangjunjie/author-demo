package com.stone.demo.author.mango.serivce;

import com.stone.demo.author.mango.bean.po.SysDict;

import java.util.List;

public interface SysDictService extends CrudService<SysDict>{

    List<SysDict> findByLabel(String label);
}
