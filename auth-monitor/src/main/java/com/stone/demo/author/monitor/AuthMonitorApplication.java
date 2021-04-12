package com.stone.demo.author.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 *
 * @Class MangoMonitorApplication
 * @Descrip TODO
 * @author Stone
 * @data 21-3-10  下午9:26
 * @Version 1.0
 */

@EnableAdminServer
@SpringBootApplication
public class AuthMonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthMonitorApplication.class, args);
    }
}
