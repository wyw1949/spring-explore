package com.yoke.bootstrap;

import com.yoke.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 通过{@link org.springframework.context.annotation.Profile}来配置bean
 */
@SpringBootApplication(scanBasePackages = {"com.yoke.service"})
public class ProfileBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ProfileBootstrap.class)
                .web(WebApplicationType.NONE)
                .profiles("Java8")
                .run(args);
        // 验证是否将helloString注册到容器
        CalculateService calculateService = context.getBean(CalculateService.class);
        System.out.println(calculateService.sum(1,2,3,4,5,6,7,8,9,10));
    }
}
