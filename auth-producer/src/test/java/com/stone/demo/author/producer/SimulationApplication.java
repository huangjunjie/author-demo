package com.stone.demo.author.producer;


public class SimulationApplication {

    /*** 直接请求服务中心 **/
    public static String URL = "http://localhost:8900/auth-producer-service/hello";

    /*** 向服务器索取相关信息 ***/
    public static String URL_PRODUCER_SERVICE_INFO = "http://localhost:46830/call";

    public static void main(String[] args) {
        System.out.println(PostUtils.post(URL_PRODUCER_SERVICE_INFO,null ,null));;
    }
}
