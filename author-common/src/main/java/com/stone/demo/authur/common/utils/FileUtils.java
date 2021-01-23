package com.stone.demo.authur.common.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/***
 *
 * @Class FileUtils
 * @Descrip TODO
 * @author Stone
 * @data 21-1-23  下午6:37
 * @Version 1.0
 */
public class FileUtils {
    public static void downloadFile(HttpServletResponse response, File file, String newFileName) {
        try {
            response.setHeader("content-Disposition", "attachment; filename = " + new String(newFileName.getBytes("ISO-8859-1"), "UTF-8"));
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            InputStream is = new FileInputStream(file.getAbsolutePath());
            BufferedInputStream bis = new BufferedInputStream(is);
            int length = 0;
            byte[] temp = new byte[1 * 1024 * 10];
            while ((length = bis.read(temp)) != -1) {
                bos.write(temp, 0, length);
            }
            bos.flush();
            bis.close();
            bos.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
