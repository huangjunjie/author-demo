package com.stone.demo.author.mango.bean.vo;

import org.springframework.http.HttpStatus;

/***
 *
 * Http 封装结果
 *
 * @author stone
 * @date 2021 - 1 - 15
 */
public class HttpResult {

    private int code = 200;

    private String msg;

    private Object data;

    public static HttpResult error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(),"未知异常请联系管理员");
    }

    public static HttpResult error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(),msg);
    }

    public static HttpResult error(int code, String msg) {
        HttpResult httpResult = new HttpResult();
        httpResult.setCode(code);
        httpResult.setMsg(msg);
        return httpResult;
    }


    public static HttpResult ok(String msg) {
        HttpResult httpResult = new HttpResult();
        httpResult.setMsg(msg);
        return httpResult;
    }

    public static HttpResult ok(Object data) {
        HttpResult httpResult = new HttpResult();
        httpResult.setData(data);
        return httpResult;
    }

    public static HttpResult ok() {
        HttpResult httpResult = new HttpResult();
        return httpResult;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
