package com.yoke.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置文件修改后客户端并不会自动的更新最新的配置
 * 可以通过集成actuator或spring-cloud-bus（消息总线）来通知客户端刷新配置文件
 * 1. 集成actuator，需要客户端集成actuator，在配置文件修改后以POST方式访问客户端http://host:port/actuator/refresh
 * 断点，即可触发客户端更新配置
 * 2. 集成spring-cloud-bus，需要客户端集成，或是服务端和客户端均集成，在配置文件修改后以POST方式访问客户端或服务端
 * http://host:port/actuator/bus-refresh
 */
@RestController
@RequestMapping("/hello")
// 将最新属性值刷新过来
@RefreshScope
public class PropertyController {

    @Value("${provider.hello}")
    private String hello;

    @RequestMapping("/get")
    public String getHello(){
        return hello;
    }
}
