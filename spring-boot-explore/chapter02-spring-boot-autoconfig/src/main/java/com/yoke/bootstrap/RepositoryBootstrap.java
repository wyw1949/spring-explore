package com.yoke.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import com.yoke.repository.MyFirstRepository;

@ComponentScan(basePackages = {"com.yoke.annotation.derive"})
public class RepositoryBootstrap {
    public static void main(String[] args) {
        /*
        采用springBoot 的形式来启动应用上下文，也可以用new XXXApplicationContext的形式
        SpringApplicationBuilder来构建启动应用，构造器的参数为资源类，相当于一个配置类，run方法将
        把应用的上下文容器返回
         */
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class)
                // 不以web的形式启动应用
                .web(WebApplicationType.NONE)
                .run(args);

        // 查看容器中是否有MyFirstRepository，即验证自定义注解是否生效
        MyFirstRepository myFirstRepository = context.getBean("myFirstRepository", MyFirstRepository.class);
        System.out.println(myFirstRepository);

        //关闭容器
        context.close();
    }
}
