package com.yoke.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 注解派生就如同类的继承一样，可以多级派生
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@FirstRepository
public @interface SecondLevelRepository {

    @AliasFor(
            annotation = FirstRepository.class, value = "name"
    )
    String value() default "";
}
