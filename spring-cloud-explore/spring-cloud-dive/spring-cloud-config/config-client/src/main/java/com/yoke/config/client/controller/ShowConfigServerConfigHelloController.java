package com.yoke.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * 通过引入actuator启动器模块，配置端点refresh，
 * 以POST方式访问http://localhost:8085/actuator/refresh，可将修改的配置文件属性刷新
 * 可以使用github的Webhooks在push后来触发上述的访问，以将使config-client获取最新的配置文件
 * 如果config-client服务比较多时，就要为每一个服务配一个Webhooks,比较麻烦，而且Webhooks是git
 * 的功能。
 * 替代方案是使用spring-cloud-bus来解决
 */
@RestController
@RequestMapping({"/", "/hello"})
@RefreshScope // 使用该注解可以将配置最新的属性值刷新进来
public class ShowConfigServerConfigHelloController {

    @Value("${hello.say}")
    private String helloSay;

    @GetMapping("/show-hello-say")
    public String showHelloSay(){
        return helloSay;
    }

}
