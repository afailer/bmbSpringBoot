package com.tjwq.bmb.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfig implements WebMvcConfigurer {

    @Value("${img_path}")
    private String imgPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println(this.imgPath);
        registry.addResourceHandler("/img/**").addResourceLocations("file:" + this.imgPath);
    }
}
