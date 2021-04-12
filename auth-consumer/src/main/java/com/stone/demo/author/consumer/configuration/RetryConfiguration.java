package com.stone.demo.author.consumer.configuration;

import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.interceptor.RetryOperationsInterceptor;

/***
 *
 * @Class RetryConfiguration
 * @Descrip TODO
 * @author Stone
 * @data 21-4-1  上午3:59
 * @Version 1.0
 */
public class RetryConfiguration {

    @Bean
    @ConditionalOnMissingBean(name = "configServerRetryInterceptor")
    public RetryOperationsInterceptor configServerRetryInterceptor() {
        return RetryInterceptorBuilder.stateless().backOffOptions(1000, 1.2, 5000).maxAttempts(10).build();
    }

}
