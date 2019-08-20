package com.tjwq.bmb.config;

import com.tjwq.bmb.intercepters.TokenIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class IntercepterConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenIntercepter()).addPathPatterns("/api/v1/content/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

}
