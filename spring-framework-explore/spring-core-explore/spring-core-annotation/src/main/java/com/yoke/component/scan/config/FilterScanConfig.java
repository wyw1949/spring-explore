package com.yoke.component.scan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(
        basePackages = "com.yoke.component.scan.filter.annotation",
        // 不启用默认扫描规则
        useDefaultFilters = false,
        // 多个includeFilters是或的关系
        includeFilters = {
                // 该包下所有被@Component标记的类
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        classes = {Component.class}
                )
        },
        // 多个excludeFilters是或的关系
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        classes = {Controller.class}
                )
        }
)
public class FilterScanConfig {
}
