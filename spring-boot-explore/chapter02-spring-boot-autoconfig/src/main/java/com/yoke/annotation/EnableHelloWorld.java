package com.yoke.annotation;

import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * 自定义Enable注解，使用@Import注解导入{@link org.springframework.context.annotation.ImportSelector}
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(MyImportSelector.class)
public @interface EnableHelloWorld {
}

