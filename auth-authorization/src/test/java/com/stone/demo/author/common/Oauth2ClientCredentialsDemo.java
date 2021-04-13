package com.stone.demo.author.common;



import java.util.HashMap;
import java.util.Map;


public class Oauth2ClientCredentialsDemo {

    private static String URL = "http://localhost:9999/oauth/token";
    private static String CLIENT_ID = "admin";
    private static String CLIENT_SECRET = "admin123456";
    private static String USER_NAME = "admin";
    private static String PASSWORD = "123456";
    private static String GRANT_TYPE = "client_credentials"; // client_credentials , password , authorization_code , refresh_token

    private static Map GET_PARAMETER_CANDIDATE = new HashMap<String, String>() {
        {
            put("client_id", CLIENT_ID);
            put("client_secret", CLIENT_SECRET);
            put("user_name", USER_NAME);
            put("password", PASSWORD);
            put("grant_type", GRANT_TYPE);
        }
    };

    public static void main(String[] args) {
        System.out.println(PostUtils.post(PostUtils.convertUrlByGetParameter(URL, GET_PARAMETER_CANDIDATE), null, null));
    }

}
