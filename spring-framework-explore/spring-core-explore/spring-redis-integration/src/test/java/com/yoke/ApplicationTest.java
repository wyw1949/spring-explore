package com.yoke;

import com.yoke.config.RedisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(classes = {RedisConfig.class})
public class ApplicationTest {
    @Test
    public void contextLoad(){

    }
}
