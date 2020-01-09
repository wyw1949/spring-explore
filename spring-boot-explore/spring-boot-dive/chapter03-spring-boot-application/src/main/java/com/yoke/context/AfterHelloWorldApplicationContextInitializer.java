package com.yoke.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

/**
 * AfterHelloWorldApplicationContextInitializer 自定义应用上下文初始化器
 * {@link Order}指定执行顺序 数值越小执行顺序越靠前
 *
 */
@Order // 默认最低优先级
public class AfterHelloWorldApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext c) {
        System.out.println("AfterHelloWorldApplicationContextInitializer context.id = " + c.getId());
    }
}
