package com.stone.demo.author.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/***
 *
 * @Class RibbonHelloController
 * @Descrip TODO
 * @author Stone
 * @data 21-3-11  上午1:04
 * @Version 1.0
 */
@RestController
public class RibbonHelloController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/ribbon/call")
    public String call() {
        String callServiceResult = restTemplate.getForObject("http://auth-producer-service/hello",String.class);
        return callServiceResult;
    }
}
