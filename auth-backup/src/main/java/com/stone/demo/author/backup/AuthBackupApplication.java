package com.stone.demo.author.backup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/***
 *
 * @Class AuthBackupApplication
 * @Descrip TODO
 * @author Stone
 * @data 21-2-22  下午6:54
 * @Version 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AuthBackupApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthBackupApplication.class, args);
    }
}
