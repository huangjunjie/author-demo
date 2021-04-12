package com.stone.demo.author.authorization.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.sql.DataSource;


/***
 *
 * @Class AuthorizationServerConfig
 * @Descrip TODO
 * @author Stone
 * @data 21-4-1  下午1:50
 * @Version 1.0
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private UserDetailsService userService;


    @Autowired
    @Qualifier("redisTokenStore")
    private TokenStore tokenStore;


    @Lazy
    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private DataSource dataSource;

    /***
     *
     * AuthorizationServerSecurityConfigurer 定义令牌端点上的安全性约束。
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        super.configure(security);
        security.allowFormAuthenticationForClients().tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    /***
     *  ClientDetailsServiceConfigurer 定义客户端详细信息服务的配置程序。可以初始化客户端详细信息，或者您可以仅引用现有商店。
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        super.configure(clients);
//        1.内存指定
//        clients.inMemory()
//                // 配置client_id
//                .withClient("admin")
//                // 配置client_secret
//                .secret(passwordEncoder.encode("admin123456"))
//                // 配置访问token的有效期
//                .accessTokenValiditySeconds(3600)
//                // 配置刷新token的有效期
//                .refreshTokenValiditySeconds(864000)
//                // 配置redirect_uri,用于授权成功后的跳转
//                .redirectUris("http://www.baidu.com")
//                // 配置申请的权限范围
//                .scopes("all")
//                // 配置grant_type,表示授权类型
//                .authorizedGrantTypes("authorization_code", "password");

//        2.JDBC
        clients.jdbc(dataSource).passwordEncoder(passwordEncoder).clients(new JdbcClientDetailsService(dataSource));

//        3.自定义
//        clients.setBuilder(new ClientDetailServiceImplBuilder());
//        clients.withClientDetails(clientDetailsService);
    }


    /**
     * AuthorizationServerEndpointsConfigurer 定义授权和令牌端点以及令牌服务。
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        super.configure(endpoints);
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userService)
                .tokenStore(tokenStore).tokenServices(defaultTokenServices());
    }

    @Primary
    @Bean
    public DefaultTokenServices defaultTokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore);
        tokenServices.setSupportRefreshToken(true);
        // tokenServices.setClientDetailsService(clientDetails());
        // token有效期自定义设置，默认12小时
        tokenServices.setAccessTokenValiditySeconds(60);
        // tokenServices.setAccessTokenValiditySeconds(60 * 60 * 12);
        // refresh_token默认30天
        tokenServices.setAccessTokenValiditySeconds(120);
        // tokenServices.setRefreshTokenValiditySeconds(60 * 60 * 24 * 7);
        return tokenServices;
    }

}
