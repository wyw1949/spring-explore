package com.yoke.conditional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:magic.properties")
@Configuration
@ComponentScan("com.yoke.conditional")
public class ConditionalConfig {

}
