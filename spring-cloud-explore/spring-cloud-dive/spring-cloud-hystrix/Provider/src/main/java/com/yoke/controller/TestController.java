package com.yoke.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider/test")
public class TestController {

    @GetMapping("/check-user")
    public String checkUser(String username){
        if ("Spring".equals(username)){
            return "SUCCESS";
        }else {
            return "FAIL";
        }
    }
}
