package com.stone.demo.author.configuration;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/***
 *
 * @Class AuthFallBackProvider
 * @Descrip TODO
 * @author Stone
 * @data 21-3-19  下午11:31
 * @Version 1.0
 */
@Component
public class AuthFallBackProvider implements FallbackProvider {
    @Override
    public String getRoute() {
        //返回熔断服务名称 全部用 “*”
        return null;

    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        /***
        *    new ClientHttpResponse
         *   改写 getBody方法
        ***/
        return null;

    }
}
