package com.yoke.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("qa")
@Configuration
public class QAProfileConfig {

    @Bean
    public EnvironmentInterface devEnvironment(){
        return new QAEnvironment();
    }
}
