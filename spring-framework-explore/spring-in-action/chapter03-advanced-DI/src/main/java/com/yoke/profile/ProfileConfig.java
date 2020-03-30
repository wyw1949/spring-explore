package com.yoke.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * {@link Profile} 可作用于bean类、{@link Configuration}类上或{@link Configuration}类内部与{@link Bean}联合使用
 *
 */

@Profile("dev")
@Configuration
@ComponentScan(basePackages = {"com.yoke.profile"})
public class ProfileConfig {

//    @Profile("dev")
//    @Bean
//    public EnvironmentInterface devEnvironment(){
//        return new DevEnvironment();
//    }
//
//    @Profile("qa")
//    @Bean
//    public EnvironmentInterface qaEnvironment(){
//        return new QAEnvironment();
//    }
//
//    @Profile("prod")
//    @Bean
//    public EnvironmentInterface prodEnvironment(){
//        return new ProdEnvironment();
//    }
}
