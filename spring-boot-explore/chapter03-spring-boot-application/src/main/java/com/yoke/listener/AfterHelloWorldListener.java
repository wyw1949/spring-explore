package com.yoke.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;

@Order
public class AfterHelloWorldListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("AfterHelloWorldListener contextRefreshedEvent = " + contextRefreshedEvent);
    }
}
