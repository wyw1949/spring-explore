package com.yoke.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * HelloWorldApplicationContextInitializer 自定义应用上下文初始化器
 * {@link Order}指定加载顺序
 * @param <C> ApplicationContext类型参数
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldApplicationContextInitializer <C extends ConfigurableApplicationContext> implements ApplicationContextInitializer<C> {
    @Override
    public void initialize(C c) {
        System.out.println("HelloWorldApplicationContextInitializer context.id = " + c.getId());
    }
}
