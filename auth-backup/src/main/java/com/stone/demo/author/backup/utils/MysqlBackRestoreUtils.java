package com.stone.demo.author.backup.utils;

import java.io.File;
import java.io.IOException;

/***
 *
 * @Class MysqlBackRestoreUtils
 * @Descrip TODO
 * @author Stone
 * @data 21-3-10  下午8:24
 * @Version 1.0
 */
public class MysqlBackRestoreUtils {


    /**
     * @param host
     * @param username
     * @param password
     * @param backupFolderPath
     * @param filename
     * @param database
     * @return
     */
    public static boolean backup(String host, String username, String password, String backupFolderPath, String filename, String database) throws Exception{
        File backupFolderFile  =  new File(backupFolderPath);
        if(!backupFolderFile.exists()) {
            backupFolderFile.mkdir();
        }

        if(!backupFolderPath.endsWith(File.separator) && !backupFolderPath.endsWith("/")) {
            backupFolderPath = backupFolderPath + File.separator;
        }

        String backupFilePath = backupFolderPath + filename;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mysqldump --opt ")
                .append(" --add-drop-database")
                .append(" --add-drop-table");
        stringBuilder.append(" -h")
                .append(host)
                .append(" -u")
                .append(username)
                .append(" -p")
                .append(password);
        stringBuilder.append(" --restore-file=").append(backupFilePath)
                .append(" --default-character-set=utf-8 ").append(database);

        Process process = Runtime.getRuntime().exec(getCommand(stringBuilder.toString()));
        if(process.waitFor() == 0) {
            System.out.println("数据已经备份到 " + backupFilePath +"文件夹");
            return true;
        }
        return false;
    }


    /**
     * @param restoreFilePath
     * @param host
     * @param username
     * @param password
     * @param database
     * @return
     */
    public static boolean restore(String restoreFilePath, String host, String username, String password, String database) throws Exception{
        File restoreFile = new File(restoreFilePath);
        if(restoreFile.isDirectory()) {
            for(File file: restoreFile.listFiles()) {
                if(file.exists() && file.getPath().endsWith(".sql")) {
                    restoreFilePath = file.getAbsolutePath();
                    break;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mysql -h").append(host)
                .append(" -u").append(username)
                .append(" -p").append(password);
        stringBuilder.append(" ").append(database).append(" < ").append(restoreFilePath);
        try {
            Process process = Runtime.getRuntime().exec(getCommand(stringBuilder.toString()));
            if (process.waitFor() == 0) {
                System.out.println("数据已从 " + restoreFilePath + " 导入到数据库中");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    private static String[] getCommand(String command) {
        String os = System.getProperty("os.name");
        String shell = "/bin/bash";
        String c = "-c";
        if(os.toLowerCase().startsWith("win")){
            shell = "cmd";
            c = "/c";
        }
        String[] cmd = { shell, c, command };
        return cmd;
    }

    public static void main(String[] args) throws Exception {
        String host = "8.129.15.54:34336";
        String userName = "admin";
        String password = "123456";
        String database = "authorization_system2021";

        System.out.println("开始备份");
        String backupFolderPath = "/home/stone";
        String fileName = "mango.sql";
        backup(host, userName, password, backupFolderPath, fileName, database);
        System.out.println("备份成功");

//        System.out.println("开始还原");
//        String restoreFilePath = "c:/dev/mango.sql";
//        restore(restoreFilePath, host, userName, password, database);
//        System.out.println("还原成功");

    }
}
