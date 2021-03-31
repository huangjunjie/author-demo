package com.stone.demo.author.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/***
 *
 * @Class AuthConfigApplication
 * @Descrip TODO
 * @author Stone
 * @data 21-4-1  上午12:38
 * @Version 1.0
 */

@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class AuthConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthConfigApplication.class,args);
    }
}
