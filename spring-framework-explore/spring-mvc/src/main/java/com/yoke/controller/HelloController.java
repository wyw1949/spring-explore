package com.yoke.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping({"hello", "hello/{userId}"})
public class HelloController {

    @GetMapping
    public String hello(){
        return "Hello Yoke!";
    }

    @PostMapping("post")
    public void post(@RequestBody User a){

        System.out.println(a);
    }

    static class User{

        private Double num;

        public User(){}

        public void setNum(Double num) {
            this.num = num;
        }

        public Double getNum() {
            return num;
        }

        @Override
        public String toString() {
            return "User=[num=" + num + "]";
        }
    }
}
