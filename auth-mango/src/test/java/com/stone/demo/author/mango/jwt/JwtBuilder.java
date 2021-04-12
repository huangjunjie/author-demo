package com.stone.demo.author.mango.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/***
 *
 * @Class JwtBuilder
 * @Descrip TODO
 * @author Stone
 * @data 21-1-24  上午12:47
 * @Version 1.0
 */
public class JwtBuilder {

    public static void main(String[] args) {
        String token = Jwts.builder()
//        主题 放入用户名
                .setSubject("liubei")
//        自定义属性 放入用户拥有请求权限
                .claim("authorities","admin")
//        失效时间
                .setExpiration(new Date(System.currentTimeMillis() + 7 * 60 * 1000))
//        签名算法和密钥
                .signWith(SignatureAlgorithm.HS512, "tmax")
                .compact();
        System.out.println(token);
    }
}
