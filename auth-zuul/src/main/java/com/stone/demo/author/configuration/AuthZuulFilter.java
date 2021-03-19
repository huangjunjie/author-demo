package com.stone.demo.author.configuration;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/***
 *
 * @Class AuthZuul
 * @Descrip TODO
 * @author Stone
 * @data 21-3-19  下午11:34
 * @Version 1.0
 */
public class AuthZuulFilter extends ZuulFilter {

    /***
     *  类型 pre route post error
     * @return
     */
    @Override
    public String filterType() {
        return null;
    }

    /**
     * 定义filter顺序 数字越小越早执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }


    /**
     *
     * 是否执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return false;
    }

    /***
     *  具体执行方法
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
