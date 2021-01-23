package com.stone.demo.authur.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/***
 *
 * @Class DateTimeUtils
 * @Descrip TODO
 * @author Stone
 * @data 21-1-23  下午9:20
 * @Version 1.0
 */
public class DateTimeUtils {

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前标准格式化日期时间
     * @param date
     * @return
     */
    public static String getDateTime() {
        return getDateTime(new Date());
    }

    /**
     * 标准格式化日期时间
     * @param date
     * @return
     */
    public static String getDateTime(Date date) {
        return (new SimpleDateFormat(DATE_FORMAT)).format(date);
    }
}
