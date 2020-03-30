package com.yoke.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class DevProfileConfig {

    @Bean
    public EnvironmentInterface devEnvironment(){
        return new DevEnvironment();
    }
}
