package com.stone.demo.author;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/***
 *
 * @Class AuthZuulApplication
 * @Descrip TODO
 * @author Stone
 * @data 21-3-19  下午11:21
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class AuthZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthZuulApplication.class, args);
    }
}
