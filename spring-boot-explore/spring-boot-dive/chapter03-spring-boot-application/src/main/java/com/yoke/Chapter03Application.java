package com.yoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * {@link SpringApplication} 需要主配置类，主配置类需要使用{@link SpringBootApplication} 注解修饰
 * {@link SpringBootApplication} 是一个模式注解，集合了
 *  {@link org.springframework.context.annotation.Configuration}
 *  {@link org.springframework.boot.autoconfigure.EnableAutoConfiguration}
 *  {@link org.springframework.context.annotation.ComponentScan}
 */
//@SpringBootApplication
public class Chapter03Application {
    public static void main(String[] args) {
        new SpringApplication(ApplicationConfig.class).run(args);
        System.out.println("----");
    }

    @SpringBootApplication
    public static class ApplicationConfig{

    }
}
