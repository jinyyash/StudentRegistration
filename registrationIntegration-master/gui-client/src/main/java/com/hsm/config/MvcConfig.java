package com.hsm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/addStudent").setViewName("addStudent");
        registry.addViewController("/greeting").setViewName("greeting");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/save").setViewName("successful");



    }
}
