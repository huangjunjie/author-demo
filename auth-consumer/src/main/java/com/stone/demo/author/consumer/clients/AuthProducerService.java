package com.stone.demo.author.consumer.clients;

import com.stone.demo.author.consumer.service.impl.AuthProducerHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 *
 * @Class AuthProducerService
 * @Descrip TODO
 * @author Stone
 * @data 21-3-11  上午1:31
 * @Version 1.0
 */

@FeignClient(name = "auth-producer-service",fallback = AuthProducerHystrix.class)
public interface AuthProducerService {

    @RequestMapping("/hello")
    public String hello();

}
