package com.gjh.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class webconfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {//file:F:upload/  "file:/root/img/"
        registry.addResourceHandler("/root/img/**").addResourceLocations("file:/root/img/");
    }
}
