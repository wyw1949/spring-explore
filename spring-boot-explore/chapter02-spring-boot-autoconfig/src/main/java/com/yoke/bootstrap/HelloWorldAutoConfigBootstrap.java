package com.yoke.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@EnableAutoConfiguration
public class HelloWorldAutoConfigBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(HelloWorldAutoConfigBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // 验正是否存在helloString bean
        String helloString = context.getBean("helloString", String.class);
        System.out.println(helloString);

        // 关闭上下文
        context.close();
    }

}
