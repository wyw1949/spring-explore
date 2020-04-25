package com.yoke.provider.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yoke.provider.entities.User;
import com.yoke.provider.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/by-id")
    public User getById(Long id){
        return userService.getById(id);
    }

    @GetMapping("by-condition")
    public List<User> getAll(User user){
        return userService.list(new QueryWrapper<>(user));
    }
}
