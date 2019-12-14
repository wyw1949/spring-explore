package com.yoke.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * 自定义一个系统属性条件注解，实现{@link Conditional}
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnSystemPropertiesCondition.class)
public @interface ConditionalOnSystemProperties {
    /**
     * 属性名称
     */
    String name() default "";

    /**
     * 属性值
     */
    String value() default "";
}
