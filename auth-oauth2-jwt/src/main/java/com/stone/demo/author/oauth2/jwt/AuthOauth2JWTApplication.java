package com.stone.demo.author.oauth2.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class AuthOauth2JWTApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthOauth2JWTApplication.class, args);
    }
}
