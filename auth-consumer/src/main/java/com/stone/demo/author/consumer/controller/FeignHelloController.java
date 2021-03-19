package com.stone.demo.author.consumer.controller;

import com.stone.demo.author.consumer.clients.AuthProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 * @Class FeignHelloController
 * @Descrip TODO
 * @author Stone
 * @data 21-3-11  上午1:32
 * @Version 1.0
 */

@RestController
public class FeignHelloController {

    @Autowired
    private AuthProducerService authProducerService;

    @RequestMapping("/feign/call")
    public String call() {
        return authProducerService.hello();
    }
}
