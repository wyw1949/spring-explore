package com.yoke.config;

import com.yoke.annotation.EnableHelloWorld;
import com.yoke.condition.ConditionalOnSystemProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 实现自定义的自动化装配配置类
 * 该类完成的自动装配：
 * {@link EnableHelloWorld} -> {@link com.yoke.annotation.MyImportSelector} -> 导入 {@link HelloWordConfig} -> helloString bean
 * 并且该类要满足{@link ConditionalOnSystemProperties} 条件注解所定义的条件才会被装配到spring
 * 要使该类被spring自动读取，需要在引导类上应用{@link org.springframework.boot.autoconfigure.EnableAutoConfiguration}
 * 并且在classpath下的META-INF/spring.factories文件中配置该类。spring将通过{@link org.springframework.core.io.support.SpringFactoriesLoader}
 * 来读取该文件。
 */
@Configuration
@EnableHelloWorld
@ConditionalOnSystemProperties(name = "user.name", value = "yoke")
public class HelloWordAutoConfig {

}
