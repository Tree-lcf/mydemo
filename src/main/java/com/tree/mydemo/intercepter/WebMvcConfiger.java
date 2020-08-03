package com.tree.mydemo.intercepter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiger implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(getLoginceprt()).addPathPatterns("/api/v1/pri/**");
        WebMvcConfigurer.super.addInterceptors(registry);

    }

    @Bean
    public LoginIntercpt getLoginceprt(){
        return new LoginIntercpt();
    }
}
