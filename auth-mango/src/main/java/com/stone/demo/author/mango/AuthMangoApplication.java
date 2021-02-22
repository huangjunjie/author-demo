package com.stone.demo.author.mango;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = "com.stone.demo.author.mango.dao")
public class AuthMangoApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthMangoApplication.class,args);
    }
}
