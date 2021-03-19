package com.stone.demo.author.common.utils;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/***
 *
 * @Class IOUtils
 * @Descrip TODO
 * @author Stone
 * @data 21-1-23  下午9:25
 * @Version 1.0
 */
public class IOUtils {

    /**
     * 关闭对象，连接
     * @param closeable
     */
    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
            // ignore
        }
    }
}
