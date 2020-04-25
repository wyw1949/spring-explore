package com.yoke.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * 自定义注解继承@Repository，具备@Repository的功能，成为@Component的派生注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Repository
public @interface FirstRepository {
    // AliasFor将属性与上级注解属性关联，若不想使用@AliasFor，需要保证派生注解与上级注解的属性一致
    @AliasFor(
            annotation = Repository.class, attribute = "value"
    )
    String name() default "";
}

