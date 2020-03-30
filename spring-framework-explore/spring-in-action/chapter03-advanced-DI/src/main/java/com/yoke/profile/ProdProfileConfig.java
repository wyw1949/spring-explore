package com.yoke.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod")
@Configuration
public class ProdProfileConfig {

    @Bean
    public EnvironmentInterface devEnvironment(){
        return new ProdEnvironment();
    }
}
