package com.yoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 要获得Hystrix Dashboard的监控，服务需要开启Hystrix并且引入actuator,开放hystrix.stream端点
 * management:
 *   endpoints:
 *     web:
 *       exposure:
 *         include: hystrix.stream
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication {

    public static void main(String[] args) {
        new SpringApplication(HystrixDashboardApplication.class).run(args);
    }
}
