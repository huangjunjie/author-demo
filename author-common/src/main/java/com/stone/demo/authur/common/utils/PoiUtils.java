package com.stone.demo.authur.common.utils;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/***
 *
 * @Class PoiUtils
 * @Descrip TODO
 * @author Stone
 * @data 21-1-23  下午9:23
 * @Version 1.0
 */
public class PoiUtils {

    /**
     * 生成Excel文件
     * @param workbook
     * @param fileName
     * @return
     */
    public static File createExcelFile(Workbook workbook, String fileName) {
        OutputStream stream = null;
        File file = null;
        try {
            file = File.createTempFile(fileName, ".xlsx");
            stream = new FileOutputStream(file.getAbsoluteFile());
            workbook.write(stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(stream);
        }
        return file;
    }
}
