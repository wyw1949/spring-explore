package com.yoke.aop;

import com.yoke.config.AopConfig;
import com.yoke.service.AspectService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAspect {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AopConfig.class);
        context.refresh();
        AspectService service = context.getBean(AspectService.class);
        service.print();
    }
}
