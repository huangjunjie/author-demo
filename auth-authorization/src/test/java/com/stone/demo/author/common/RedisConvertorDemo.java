package com.stone.demo.author.common;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RedisConvertorDemo {
    public static void main(String[] args) {
        String origin = "\\xac\\xed\\x00\\x05sr\\x00Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\\xdfGc\\x9d\\xd0\\xc9\\xb7\\x02\\x00\\x01L\\x00\\x0aexpirationt\\x00\\x10Ljava/util/Date;xr\\x00Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\\xe1\\x0e\\x0acT\\xd4^\\x02\\x00\\x01L\\x00\\x05valuet\\x00\\x12Ljava/lang/String;xpt\\x00$4e552eab-328c-4f08-99ac-0aab4103c406sr\\x00\\x0ejava.util.Datehj\\x81\\x01KYt\\x19\\x03\\x00\\x00xpw\\x08\\x00\\x00\\x01ya\\xd5\\x8e+x";
        Pattern pattern = Pattern.compile("(\\\\\\\\x[0-9A-Fa-f]{2})+");
        Matcher matcher = pattern.matcher(origin);
        Map<String,String> result = new TreeMap<>();
        List<String> listKey = new LinkedList<>();
        while (matcher.find()) {
            String group = matcher.group(0);
            String groupReplace = group.replaceAll("\\\\\\\\x", "");
            byte[] b = new byte[groupReplace.length() / 2];// 每两个字符为一个十六进制确定数字长度
            for (int i = 0; i < b.length; i++) {
                // 将字符串每两个字符做为一个十六进制进行截取
                String a = groupReplace.substring(i * 2, i * 2 + 2);
                b[i] = (byte) Integer.parseInt(a, 16);// 将如e4转成十六进制字节，放入数组
            }
            try {
                // 将字节数字以utf-8编码以字符串形式输出
                String ccc = new String(b, "UTF-8");
                result.put(ccc,group);
                listKey.add(ccc);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if(listKey != null && listKey.size() > 0){
            listKey.sort(Comparator.reverseOrder());
            for (String key : listKey ) {
                String value = result.get(key);
                origin = origin.replace(value, key);
            }
        }
        System.out.println(origin);
    }
}
