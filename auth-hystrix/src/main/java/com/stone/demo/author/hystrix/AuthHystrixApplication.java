package com.stone.demo.author.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/***
 *
 * @Class AuthHystrixApplication
 * @Descrip TODO
 * @author Stone
 * @data 21-3-19  下午10:07
 * @Version 1.0
 */
@EnableTurbine
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
public class AuthHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthHystrixApplication.class, args);
    }
}
