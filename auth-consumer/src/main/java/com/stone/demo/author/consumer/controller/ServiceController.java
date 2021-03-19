package com.stone.demo.author.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 * @Class ServiceController
 * @Descrip TODO
 * @author Stone
 * @data 21-3-10  下午11:14
 * @Version 1.0
 */
@RestController
public class ServiceController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("services")
    public Object services() {
        return discoveryClient.getInstances("auth-producer-service");
    }

    @RequestMapping("discovery")
    public Object discovery() {
        return loadBalancerClient.choose("auth-producer-service").getUri().toString();
    }

}
