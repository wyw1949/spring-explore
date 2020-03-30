package com.yoke.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigClientApplication {
    public static void main(String[] args) {
        new SpringApplication(ConfigClientApplication.class).run(args);
    }
}
