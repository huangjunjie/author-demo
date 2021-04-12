package com.stone.demo.author.mango.serivce;

import com.stone.demo.author.mango.bean.vo.PageRequest;
import com.stone.demo.author.mango.bean.vo.PageResult;

import java.util.List;

/***
 * 通用 CRUD 接口
 *
 * @author  Stone
 * @data  2021- 1 -15
 */
public interface CrudService<T> {

    /**
     * 通用保存接口
     *
     * @param record
     * @return
     */
    int save(T record);

    /***
     * 单点删除接口
     *
     * @param record
     * @return
     */
    int delete(T record);

    /**
     *批量删除接口
     *
     * @param records
     * @return
     */
    int delete(List<T> records);

    /**
     * 通过id查看数据接口
     *
     * @param id
     * @return
     */
    T findById(Long id);

    /**
     * 查看分页接口
     *
     * @param request
     * @return
     */
    PageResult findPage(PageRequest request);

}
