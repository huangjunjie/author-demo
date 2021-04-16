package com.stone.demo.author.oauth2.jwt.client;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/****
 *
 *  @EnableOAuth2Sso
 *  注解帮助我们快速的将我们的OAuth2 Client应用接入授权服务器完成基于OAuth2的SSO流程，创建登录状态.
 *  增强的逻辑是在SpringSecurityFilterChain过滤器 OAuth2ClientAuthenticationProcessingFilter
 *  这个用于登录认证的Filter，其使用的是OAuth2授权码流程，以下都是这个Filter负责的功能
 *
 * 将用户重定向到授权服务器获取授权
 * 根据code授权码和OAuth2 clientId、secret获取访问令牌(OAuth2AccessToken.class)
 * 最后使用 ResourceServerTokenServices (RemoteTokenServices 向授权服务器发送请求获取认证授权信息) 并携带访问令牌获取用户信息，创建Authentication登录后凭证，完成登录
 *
 */
@EnableOAuth2Sso
@EnableDiscoveryClient
@SpringBootApplication
public class AuthOauth2JwtClientApplications {

    public static void main(String[] args) {
        SpringApplication.run(AuthOauth2JwtClientApplications.class, args);
    }
}
