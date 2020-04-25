package com.yoke.controller;

import com.yoke.feign.TestProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign/hystrix")
public class TestProviderFeignController {
    @Autowired
    private TestProvider testProvider;

    @GetMapping("check-user")
    public String checkUser(String username){
        return testProvider.checkUser(username);
    }

    @GetMapping("/forProvider")
    public String forProvider(){
        return "forProvider";
    }

    @GetMapping("/forProvider2")
    public String forProvider2(){
        return "forProvider2";
    }
}
