package com.yoke.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yoke.provider.entities.User;
import com.yoke.provider.mapper.UserMapper;
import com.yoke.provider.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
