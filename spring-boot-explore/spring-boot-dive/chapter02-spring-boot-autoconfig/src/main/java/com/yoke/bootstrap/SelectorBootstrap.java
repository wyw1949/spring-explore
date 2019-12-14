package com.yoke.bootstrap;

import com.yoke.annotation.EnableHelloWorld;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 通过{@link EnableHelloWorld}导入{@link com.yoke.annotation.MyImportSelector}
 * 在{@link com.yoke.annotation.MyImportSelector}导入了配置类{@link com.yoke.config.HelloWordConfig}
 * {@link com.yoke.config.HelloWordConfig}中配置了一个String的bean(helloString)
 */
@EnableHelloWorld
public class SelectorBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(SelectorBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
        // 验证是否将helloString注册到容器
        String helloString = context.getBean("helloString", String.class);
        System.out.println(helloString);
    }
}
