package com.stone.demo.author.backup.service;

/***
 *
 * @Class MysqlBackupService
 * @Descrip TODO
 * @author Stone
 * @data 21-3-10  下午8:16
 * @Version 1.0
 */
public interface MysqlBackupService {


    /**
     * @param host
     * @param username
     * @param password
     * @param backupFolderPath
     * @param filename
     * @param database
     * @return
     */
    boolean backup(String host, String username, String password, String backupFolderPath, String filename, String database) throws Exception;



    /**
     * @param restoreFilePath
     * @param host
     * @param username
     * @param password
     * @param database
     * @return
     * @throws Exception
     */
    boolean restore(String restoreFilePath, String host, String username, String password, String database) throws Exception;

}
