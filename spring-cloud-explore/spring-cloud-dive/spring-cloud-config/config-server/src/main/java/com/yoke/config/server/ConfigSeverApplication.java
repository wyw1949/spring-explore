package com.yoke.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import sun.security.krb5.Config;

/**
 * spring-cloud-config-server可以通过下列形式访问(GET)配置文件
 * http://localhost:port/{application}/{profile}[/{label}]
 * http://localhost:port/{application}-{profile}.yml
 * http://localhost:port/{label}/{application}-{profile}.yml
 * http://localhost:port/{application}-{profile}.properties
 * http://localhost:port/{label}/{application}-{profile}.properties
 * application为配置文件名
 * profile为配置文件环境
 * label为分支
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigSeverApplication {
    public static void main(String[] args) {
        new SpringApplication(ConfigSeverApplication.class).run(args);
    }
}
