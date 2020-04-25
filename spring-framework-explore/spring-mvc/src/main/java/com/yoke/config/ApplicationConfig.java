package com.yoke.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.List;

@Configuration
@ComponentScan(basePackages = {"com.yoke"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.yoke.controller")
})
public class ApplicationConfig{

    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
    }
}
