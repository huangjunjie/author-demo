package com.stone.demo.author.backup.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/***
 *
 * @Class BackupDataSourceProperties
 * @Descrip TODO
 * @author Stone
 * @data 21-3-10  下午9:06
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "mango.backup.datasource")
public class BackupDataSourceProperties {

    private String host;

    private String userName;

    private String password;

    private String database;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
