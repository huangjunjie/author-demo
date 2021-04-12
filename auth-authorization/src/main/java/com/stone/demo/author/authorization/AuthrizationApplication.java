package com.stone.demo.author.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/***
 *
 * @Class AuthrizationApplication
 * @Descrip TODO
 * @author Stone
 * @data 21-4-1  下午1:45
 * @Version 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AuthrizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthrizationApplication.class, args);
    }
}
