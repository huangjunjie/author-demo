package com.stone.demo.author.mango.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stone.demo.author.mango.bean.vo.PageRequest;
import com.stone.demo.author.mango.bean.vo.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import java.util.List;

/***
 *Mybatis 分页查询助手
 *
 * @author stone
 * @date 2021 - 1 -15
 */
public class MybatisPageHelper {

    private static final Logger log = LoggerFactory.getLogger(MybatisPageHelper.class);


    public static final String findPage = "findPage";


    /**
     * 查询分页
     *
     * @param request
     * @param objectMapper
     * @return
     */
    public static PageResult findPage(PageRequest request, Object objectMapper) {
        return findPage(request, objectMapper, findPage);
    }

    /**
     * 调用分页插件进行分页查询
     *
     * @param request
     * @param objectMapper
     * @param findPage
     * @param args
     * @return
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    private static PageResult findPage(PageRequest request, Object objectMapper, String findPage, Object... args) {
        // 设置分页参数
        int pageNum = request.getPageNum();
        int pageSize = request.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        // 利用反射调用查询方法
        Object result = null;
        try {
            result = ReflectionUtils.invokeMethod(objectMapper.getClass().getMethod(findPage), args);
        } catch (NoSuchMethodException e) {
            log.info("[com.stone.demo.author.mango.utils.MybatisPageHelper] Invoke Method Failure ." +
                    " params : request = {} , objectMapper = {}", request, objectMapper);
            throw new IllegalStateException("MybatisPageHelper Runtime Error.");
        }
        return getPageResult(request, new PageInfo((List) result));
    }

    /***
     * 将分页信息封装到统一接口
     *
     * @param request
     * @param pageInfo
     * @return
     */
    private static PageResult getPageResult(PageRequest request, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
