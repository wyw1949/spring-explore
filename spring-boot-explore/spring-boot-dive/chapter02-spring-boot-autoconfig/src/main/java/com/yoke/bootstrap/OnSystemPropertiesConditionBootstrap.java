package com.yoke.bootstrap;

import com.yoke.condition.ConditionalOnSystemProperties;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

public class OnSystemPropertiesConditionBootstrap {

    @Bean
    @ConditionalOnSystemProperties(name = "user.name", value = "yoke")
    public String helloWord(){
        return "Hello world, Conditional";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(OnSystemPropertiesConditionBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // 根据名称和类型获取bean
        String helloWorld = context.getBean("helloWord", String.class);
        System.out.println(helloWorld);

        context.close();
    }
}
