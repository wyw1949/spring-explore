package com.yoke.annotation;

import com.yoke.config.HelloWordConfig;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 实现 {@link ImportSelector}
 * 可以在{@see MyImportSelector#selectImports(AnnotationMetadata)}中自定义逻辑导入bean
 * 注意返回的是字符串数组，里面是类的全限定名
 */
public class MyImportSelector implements ImportSelector {
    // 返回类全限定名的数组
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{HelloWordConfig.class.getName()};
    }
}
