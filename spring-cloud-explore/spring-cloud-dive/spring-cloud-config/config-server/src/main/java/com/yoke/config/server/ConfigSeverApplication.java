package com.yoke.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import sun.security.krb5.Config;

@SpringBootApplication
@EnableConfigServer
public class ConfigSeverApplication {
    public static void main(String[] args) {
        new SpringApplication(ConfigSeverApplication.class).run(args);
    }
}
