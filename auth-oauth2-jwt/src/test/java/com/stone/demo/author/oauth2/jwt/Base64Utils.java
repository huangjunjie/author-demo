package com.stone.demo.author.oauth2.jwt;

import sun.misc.BASE64Decoder;

import java.io.IOException;

public class Base64Utils {

    private static String str1 = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
    private static  String str2 = "eyJzY29wZSI6WyJhbGwiXSwiZXhwIjoxNjE4NTE3OTY4LCJqdGkiOiIzNDFmOWQ1Zi0yMDU0LTQ1MmItOWE2OS05YTdjOTE4MmUxYWQiLCJjbGllbnRfaWQiOiJhZG1pbiIsImVuaGFuY2UiOiJlbmhhbmNlIGluZm8ifQ";
    private static  String str3 ="bXOFlHMtp1r5Mo6IHHB2KKFf5ohsbI2aKPS_oPruLto";

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
