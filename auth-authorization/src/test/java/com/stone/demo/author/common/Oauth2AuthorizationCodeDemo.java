package com.stone.demo.author.common;

import java.util.HashMap;
import java.util.Map;

public class Oauth2AuthorizationCodeDemo {
    private static String URL_AUTHORIZATION = "http://localhost:9999/oauth/authorize";
    private static String URL_TOKEN = "http://localhost:9999/oauth/token";
    private static String RESPONSE_TYPE = "code";
    private static String RESPONSE_TYPE2 = "authorization_code";
    private static String RESPONSE_TYPE3 = "refresh_token";
    private static String CLIENT_ID = "admin";
    private static String CLIENT_SECRET = "admin123456";
    private static String REDIRECT_URI = "http://www.baidu.com";

    private static Map GET_PARAMETER_CANDIDATE = new HashMap<String, String>() {
        {
            put("response_type", RESPONSE_TYPE);
            put("client_id", CLIENT_ID);
            put("redirect_uri", REDIRECT_URI);
        }
    };

    private static Map GET_PARAMETER_CANDIDATE2 = new HashMap<String, String>() {
        {
            put("grant_type", RESPONSE_TYPE2);
            put("client_id", CLIENT_ID);
            put("client_secret", CLIENT_SECRET);
            put("redirect_uri", REDIRECT_URI);
        }
    };

    private static Map GET_PARAMETER_CANDIDATE3 = new HashMap<String, String>() {
        {
            put("grant_type", RESPONSE_TYPE3);
            put("client_id", CLIENT_ID);
            put("client_secret", CLIENT_SECRET);
        }
    };

    public static void main(String[] args) {
        //获取 Code
//        String post = PostUtils.post(PostUtils.convertUrlByGetParameter(URL_AUTHORIZATION, GET_PARAMETER_CANDIDATE), null, null);
//        System.out.println(post);

        //获取accessToken
//        GET_PARAMETER_CANDIDATE2.put("code","m3aBjY");
//        PostUtils.post(PostUtils.convertUrlByGetParameter(URL_TOKEN, GET_PARAMETER_CANDIDATE2), null, null);

        //刷新refresh_token
        GET_PARAMETER_CANDIDATE3.put("refresh_token","42e9f8a9-14b6-4aff-8e6a-f550457bc76f");
        PostUtils.post(PostUtils.convertUrlByGetParameter(URL_TOKEN, GET_PARAMETER_CANDIDATE3), null, null);

    }
}
