package com.zerobase.semiproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebMvcConfiguration {

    private final List<String> ALLOW_DOMAIN_LIST = List.of("http://webserver1.com", "http://webserver2.com");

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                ALLOW_DOMAIN_LIST.forEach(ALLOW_DOMAIN -> {
                    registry.addMapping("/**").allowedOrigins(ALLOW_DOMAIN);
                });
            }
        };
    }
}
