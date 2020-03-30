package com.yoke.introduce;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.yoke.introduce"})
@EnableAspectJAutoProxy
public class IntroduceAOPConfig {
}
