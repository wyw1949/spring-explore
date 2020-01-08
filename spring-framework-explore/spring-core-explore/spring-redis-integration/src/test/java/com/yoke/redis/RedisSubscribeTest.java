package com.yoke.redis;

import com.yoke.ApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisSubscribeTest extends ApplicationTest {

    @Autowired
    private RedisTemplate<String, String> template;

    @Test
    public void subscribeTest() throws InterruptedException {
        template.convertAndSend("chata", "Hello world!");
        Thread.sleep(1000*60);
    }
}
