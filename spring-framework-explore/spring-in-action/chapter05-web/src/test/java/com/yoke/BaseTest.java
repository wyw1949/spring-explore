package com.yoke;

import com.yoke.config.WebMVCConfig;
import com.yoke.config.WebRootConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
// 测试web项目要加此注解
@WebAppConfiguration
@ContextConfiguration(classes = {WebRootConfig.class/*, WebMVCConfig.class*/})
public class BaseTest {
}
