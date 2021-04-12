package com.stone.demo.author.common;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;

import javax.sql.DataSource;
import java.util.HashSet;
import java.util.Set;

/***
 *
 * @Class ClientDetailServiceImplBuilder
 * @Descrip TODO
 * @author Stone
 * @data 21-4-1  下午6:51
 * @Version 1.0
 */
public class ClientDetailServiceImplBuilder extends ClientDetailsServiceBuilder<ClientDetailServiceImplBuilder> {

    private Set<ClientDetails> clientDetails = new HashSet<ClientDetails>();

    private DataSource dataSource;

    private PasswordEncoder passwordEncoder; // for writing client secrets

    public ClientDetailServiceImplBuilder dataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        return this;
    }

    public ClientDetailServiceImplBuilder passwordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        return this;
    }

    @Override
    protected void addClient(String clientId, ClientDetails value) {
        clientDetails.add(value);
    }

    @Override
    protected ClientDetailsService performBuild() {
//        Assert.state(dataSource != null, "You need to provide a DataSource");
        ClientDetailsServiceImpl clientDetailsService = new ClientDetailsServiceImpl();
//            if (passwordEncoder != null) {
//                // This is used to encode secrets as they are added to the database (if it isn't set then the user has top
//                // pass in pre-encoded secrets)
//                clientDetailsService.setPasswordEncoder(passwordEncoder);
//            }
        for (ClientDetails client : clientDetails) {
            // 插入方法
//                clientDetailsService.addClientDetails(client);
        }
        return clientDetailsService;
    }

}

