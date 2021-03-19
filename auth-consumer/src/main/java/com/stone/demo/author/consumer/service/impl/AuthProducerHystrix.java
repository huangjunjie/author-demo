package com.stone.demo.author.consumer.service.impl;

import com.stone.demo.author.consumer.clients.AuthProducerService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 *
 * @Class AuthProducerHystrix
 * @Descrip TODO
 * @author Stone
 * @data 21-3-19  下午9:46
 * @Version 1.0
 */

@Component
public class AuthProducerHystrix implements AuthProducerService {

    @RequestMapping("/hello")
    public String hello() {
        return "sorry, hello service call failed.";
    }
}
