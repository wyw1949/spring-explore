package com.yoke.normal;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {

    @Pointcut("execution(* com.yoke.normal.MusicPerformance.perform(java.lang.String, int)) && args(title, num)")
    public void perform(String title, int num){

    }

    @Before("perform(title, num)")
    public void takeSeat(String title, int num){
        System.out.println("观众就坐，准备表演音乐：" + title + ", " + num);
    }

    @AfterReturning("perform(title, num)")
    public void applause(String title, int num){
        System.out.println("CLAP! CLAP! CLAP!");
    }

    @AfterThrowing("perform(title, num)")
    public void demandRefund(String title, int num){
        System.out.println("DemandRefund");
    }
}
