package com.stone.demo.author.producer;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.util.ObjectUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PostUtils {

    private static String LINK_SEPERATOR = "?";

    private static String PARAMETER_SEPERATOR = "&";

    private static String EQUALS_CHAR = "=";

    /***
     *  提交
     * @param url
     * @param postCandidate
     * @param headsCandidate
     * @return
     */
    public static String post(String url, Map postCandidate, Map headsCandidate) {
        /***  获取请求端 ***/
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        /***  设置头部信息 ***/
        httpPost.setHeader("Content-Type", ContentType.APPLICATION_JSON.withCharset("UTF-8").toString());
        if (!ObjectUtils.isEmpty(headsCandidate)) {
            Set<Map.Entry> sets = headsCandidate.entrySet();
            for (Map.Entry entry : sets) {
                httpPost.setHeader((String) entry.getKey(), (String) entry.getValue());
            }
        }
        String result = "";
        /***  设置参数  **/
        String data = ObjectUtils.isEmpty(postCandidate) ? "" : JSON.toJSONString(postCandidate);
        try {
            StringEntity stringEntity = new StringEntity(data);
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            CloseableHttpResponse response2 = httpClient.execute(httpPost);
            HttpEntity entity2 = response2.getEntity();
            result = EntityUtils.toString(entity2, "UTF-8");
            System.out.println(" 请求成功！ " + result);
        } catch (Exception e) {
            System.out.println(" 请求失败！ " + e.getMessage());
        } finally {
        }
        return result;
    }


    /***
     *  URL拼接参数
     * @param url
     * @param parameterCandiata
     * @return
     */
    public static String convertUrlByGetParameter(String url, Map parameterCandiata) {
        if (StringUtils.isBlank(url) || ObjectUtils.isEmpty(parameterCandiata)) {
            throw new IllegalArgumentException("url or Get parameter is empty");
        }
        StringBuilder stringBuilder = new StringBuilder(url);
        stringBuilder.append(LINK_SEPERATOR);
        Set<Map.Entry> sets = parameterCandiata.entrySet();
        Iterator<Map.Entry> entryIterator = sets.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry tempraryEntry = entryIterator.next();
            if (!StringUtils.isBlank((String) tempraryEntry.getKey()) && !StringUtils.isBlank((String) tempraryEntry.getValue())) {
                stringBuilder.append(tempraryEntry.getKey()).append(EQUALS_CHAR).append(tempraryEntry.getValue());
            }
            if (entryIterator.hasNext()) {
                stringBuilder.append(PARAMETER_SEPERATOR);
            }
        }
        return stringBuilder.toString();
    }
}
