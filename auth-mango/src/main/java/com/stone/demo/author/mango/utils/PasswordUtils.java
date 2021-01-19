package com.stone.demo.author.mango.utils;

import java.util.UUID;

/***
 *
 * 密码工具类
 * @Class PasswordUtils
 * @Descrip TODO
 * @author Stone
 * @data 21-1-18  下午12:20
 * @Version 1.0
 */
public class PasswordUtils {

    /**
     * 匹配密码
     * @param salt 盐
     * @param rawPass 明文
     * @param encPass 密文
     * @return
     */
    public static boolean matches(String salt, String rawPass, String encPass) {
        return new PasswordEncoder(salt).matches(encPass, rawPass);
    }

    /**
     * 明文密码加密
     * @param rawPass 明文
     * @param salt
     * @return
     */
    public static String encode(String rawPass, String salt) {
        return new PasswordEncoder(salt).encode(rawPass);
    }

    /**
     * 获取加密盐
     * @return
     */
    public static String getSalt() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
    }
}
