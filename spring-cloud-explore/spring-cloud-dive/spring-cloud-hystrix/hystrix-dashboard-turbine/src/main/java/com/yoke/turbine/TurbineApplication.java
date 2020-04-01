package com.yoke.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Turbine可以聚合整个集群下的监控
 */
@SpringBootApplication
@EnableEurekaClient
@EnableTurbine
@EnableHystrixDashboard
public class TurbineApplication {
    public static void main(String[] args) {
        new SpringApplication(TurbineApplication.class).run(args);
    }
}
