package com.yoke.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWordConfig {

    @Bean
    public String helloString(){
        return "hello world Myself ImportSelector";
    }
}
