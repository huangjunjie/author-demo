package com.stone.demo.author.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/***
 *
 * @Class AuthProducerApplication
 * @Descrip TODO
 * @author Stone
 * @data 21-3-10  下午10:59
 * @Version 1.0
 */

@EnableDiscoveryClient
@SpringBootApplication
public class AuthProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthProducerApplication.class, args);
    }
}
