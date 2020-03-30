package com.yoke.introduce;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * 引入增强切面
 * 引入增强可以给bean增加新的方法
 */
@Aspect
@Component
public class EncoreableIntroducer {

    // 指定要引入的目标类，指定引入方法的实现类
    @DeclareParents(value = "com.yoke.introduce.*Performance",
            defaultImpl = DefualtEncoreableImpl.class)
    public Encoreable encoreable;
}
