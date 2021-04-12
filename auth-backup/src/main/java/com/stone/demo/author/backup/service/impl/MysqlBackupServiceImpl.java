package com.stone.demo.author.backup.service.impl;

import com.stone.demo.author.backup.service.MysqlBackupService;
import com.stone.demo.author.backup.utils.MysqlBackRestoreUtils;
import org.springframework.stereotype.Service;

/***
 *
 * @Class MysqlBackupServiceImpl
 * @Descrip TODO
 * @author Stone
 * @data 21-3-10  下午8:22
 * @Version 1.0
 */
@Service
public class MysqlBackupServiceImpl implements MysqlBackupService {
    /**
     * @param host
     * @param username
     * @param password
     * @param backupFolderPath
     * @param filename
     * @param database
     * @return
     */
    @Override
    public boolean backup(String host, String username, String password, String backupFolderPath, String filename, String database) throws Exception {
        return MysqlBackRestoreUtils.backup(host,username,password,backupFolderPath,filename,database);
    }

    /**
     * @param restoreFilePath
     * @param host
     * @param username
     * @param password
     * @param database
     * @return
     * @throws Exception
     */
    @Override
    public boolean restore(String restoreFilePath, String host, String username, String password, String database) throws Exception {
        return MysqlBackRestoreUtils.restore(restoreFilePath,host,username,password,database);
    }
}
