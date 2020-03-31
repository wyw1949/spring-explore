package com.yoke.a.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/", "/a"})
public class HelloController {

    @GetMapping
    public String hello(){
        return "Hello! I'm service a";
    }

}