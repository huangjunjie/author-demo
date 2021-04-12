package com.stone.demo.author.mango.serivce;

import com.stone.demo.author.mango.bean.po.SysConfig;

import java.util.List;

public interface SysConfigService extends CrudService<SysConfig> {

    List<SysConfig> findByLabel(String lable);
}
