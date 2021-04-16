package com.stone.demo.author.oauth2.jwt.server;

import sun.misc.BASE64Decoder;

import java.io.IOException;

public class Base64Utils {
//    eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJzdG9uZSIsInNjb3BlIjpbImFsbCJdLCJleHAiOjE2MTg2MTE3NjcsImF1dGhvcml0aWVzIjpbImFkbWluIl0sImp0aSI6ImIxZTViZTM2LWEwYzQtNDJjNi1iNTMyLThiODdhZWNjMmFmZSIsImNsaWVudF9pZCI6ImFkbWluIiwiZW5oYW5jZSI6ImVuaGFuY2UgaW5mbyJ9.-GDwdj51lqPo8KRiNe728pV8qPmcn5TNREhlf4YcS9Y
    private static String str1 = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
    private static  String str2 = "eyJ1c2VyX25hbWUiOiJzdG9uZSIsInNjb3BlIjpbImFsbCJdLCJleHAiOjE2MTg2MTE3NjcsImF1dGhvcml0aWVzIjpbImFkbWluIl0sImp0aSI6ImIxZTViZTM2LWEwYzQtNDJjNi1iNTMyLThiODdhZWNjMmFmZSIsImNsaWVudF9pZCI6ImFkbWluIiwiZW5oYW5jZSI6ImVuaGFuY2UgaW5mbyJ9";
    private static  String str3 ="-GDwdj51lqPo8KRiNe728pV8qPmcn5TNREhlf4YcS9Y";

    public static void main(String[] args) {

        BASE64Decoder decoder = new BASE64Decoder();
        try {
            System.out.println(new String(decoder.decodeBuffer(str1)));
            System.out.println(new String(decoder.decodeBuffer(str2)));
            System.out.println(new String(decoder.decodeBuffer(str3)));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
