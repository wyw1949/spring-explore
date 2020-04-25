package com.yoke.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZuulServiceApplicationA {
    public static void main(String[] args) {
        new SpringApplication(ZuulServiceApplicationA.class).run(args);
    }
}
