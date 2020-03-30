package com.yoke.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* com.yoke.service.*.*(..))")
    public void pointcut(){}

    @Before(value = "pointcut()")
    public void before(){
        System.out.println("前置。。。。。");
    }
}
