package com.piesat.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/photos/**").addResourceLocations("file:/D:/git_dev/FengJing/code/fengjing/src/main/resources/photos/");
        super.addResourceHandlers(registry);
    }
}
