package com.yoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableFeignClients
public class FeignHystrixClientApplication {
    public static void main(String[] args) {
        new SpringApplication(FeignHystrixClientApplication.class).run(args);
    }
}
