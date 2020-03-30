package com.yoke.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hystrix/test")
public class HystrixTestController {

    @GetMapping("/check-user")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String checkUser(String username){
        if ("spring".equals(username)){
            return "SUCCESS";
        }else {
            throw new RuntimeException();
        }
    }

    public String fallbackMethod(String username){
        return "EXCEPTION";
    }
}
