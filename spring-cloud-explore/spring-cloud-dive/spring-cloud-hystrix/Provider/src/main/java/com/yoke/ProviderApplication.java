package com.yoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderApplication {
    public static void main(String[] args) {
        new SpringApplication(ProviderApplication.class).run(args);
    }
}
