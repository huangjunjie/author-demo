package com.stone.demo.author.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

/***
 *
 * @Class utils
 * @Descrip TODO
 * @author Stone
 * @data 21-4-1  下午10:14
 * @Version 1.0
 */
public class PassEncoderUtils {
    public static void main(String[] args) {
        BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
        String scret = passEncoder.encode("admin123456");
        System.out.println(scret);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BCryptPasswordEncoder passEncoder2 = new BCryptPasswordEncoder();
        System.out.println(passEncoder2.matches("admin123456",scret));
        String secret = passEncoder.encode("admin123456");
        System.out.println(passEncoder.matches("admin123456",secret));
        System.out.println(passEncoder.encode("123456"));
    }
}

//$2a$10$j5p87wWhGi43/7QNLN.bDuN1/V/P/wztO7FxcyMbM.XYC2y7uPOQq
//$2a$10$jFoRfeU8IpQENfZYPkCMVeBSxvB2Q4N5d2Vi61PI6LijtN0iOnive