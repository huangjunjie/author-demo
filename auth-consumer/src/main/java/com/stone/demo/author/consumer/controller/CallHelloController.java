package com.stone.demo.author.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/***
 *
 * @Class CallHelloController
 * @Descrip TODO
 * @author Stone
 * @data 21-3-10  下午11:33
 * @Version 1.0
 */
@RestController
public class CallHelloController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/call")
    public String call() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("auth-producer-service");
        System.out.println("服务地址： "+ serviceInstance.getUri());
        System.out.println("服务名称： "+ serviceInstance.getServiceId());

        String callServiceResult = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/hello",String.class);
        System.out.println(callServiceResult);
        return callServiceResult;
    }
}
