package com.stone.demo.author.backup.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/***
 *
 * @Class CorsConfig
 * @Descrip TODO
 * @author Stone
 * @data 21-3-10  下午8:09
 * @Version 1.0
 */

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    /**
     * Configure cross origin requests processing.
     *
     * @param registry
     * @since 4.2
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(168000)
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
