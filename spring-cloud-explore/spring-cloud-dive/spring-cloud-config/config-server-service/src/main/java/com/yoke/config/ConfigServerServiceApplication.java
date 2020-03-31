package com.yoke.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * spring-cloud 支持的访问方式
 * http://localhost:port/{application}/{profile}[/{label}]
 * http://localhost:port/{application}-{profile}.yml
 * http://localhost:port/{application}-{profile}.properties
 * http://localhost:port/{label}/{application}-{profile}.yml
 * http://localhost:port/{label}/{application}-{profile}.properties
 * application: 配置文件名
 * profile: 环境名
 * label: 分支
 *
 * 对于修改配置文件后，修改内容并不会自动同步到客户端，可以有两种方式。
 * 1. 客户端集成actuator，在修改配置文件后以POST形式访问客户端的/actuator/refresh端点，即可通知客户端更新配置，
 * 并且引用配置文件的属性的类上添加@RefreshScope注解
 * 2. 服务端和客户端集成spring-cloud-bus（消息总线），修改文件后访问客户端或服务端的/actuator/bus-refresh端点，
 * 即可通知客户端更新配置，并且引用配置文件的属性的类上添加@RefreshScope注解
 *
 * 通过配置git的Webhooks来出发端点的访问
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerServiceApplication.class, args);
	}

}
