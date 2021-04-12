package com.stone.demo.author.consumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 * @Class SpringConfigController
 * @Descrip TODO
 * @author Stone
 * @data 21-4-1  上午1:53
 * @Version 1.0
 */
@RefreshScope
@RestController
public class SpringConfigController {

    @Value("${hello}")
    private String hello;

    @RequestMapping("/hello")
    public String from() {
        return this.hello;
    }
}
