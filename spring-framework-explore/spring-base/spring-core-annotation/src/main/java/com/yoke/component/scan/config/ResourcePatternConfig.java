package com.yoke.component.scan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        basePackages = "com.yoke.component.scan",
        // 配置相对于basePackages的ant风格的路径
        resourcePattern = "resource/pattern/**/*Pattern.class"
)
public class ResourcePatternConfig {

}
