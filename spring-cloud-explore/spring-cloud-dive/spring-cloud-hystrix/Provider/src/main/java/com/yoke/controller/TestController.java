package com.yoke.controller;

import com.yoke.feign.GetHystrixFeignForProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider/test")
public class TestController {
    @Autowired
    private GetHystrixFeignForProvider getHystrixFeignForProvider;

    @GetMapping("/check-user")
    public String checkUser(String username){
        if ("Spring".equals(username)){
            return "SUCCESS";
        }else {
            return "FAIL";
        }
    }

    @GetMapping("/forProvider")
    public String forProvider(){
        return getHystrixFeignForProvider.forProvider();
    }

}
