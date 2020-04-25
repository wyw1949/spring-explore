package com.yoke.redis;

import com.yoke.ApplicationTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * String类型数据操作
 */
public class RedisStringTest extends ApplicationTest {

    // 应制定泛型<K,V>，不指定的话将会有警告. K：key的类型，V：value的类型
    @Autowired
    private RedisTemplate<String, Object> template;

    @Test
    public void testStringSet() throws InterruptedException {
        // 设置key-value
        template.opsForValue().set("String", "123");
        // 获取value
        Object value = template.opsForValue().get("String");
        Assert.assertEquals("123", value);
        // SETNX命令，如果已经存在就不设置了，返回操作结果，成功为true，失败为false
        Boolean res = template.opsForValue().setIfAbsent("String", "456");
        Assert.assertNotNull(res);
        Assert.assertFalse(res);

        // SETEX设置过期时间，单位为s。SETPX 单位为ms。
        template.expire("String", 10, TimeUnit.SECONDS);
        Thread.sleep(11 * 1000);
        Object expireValue = template.opsForValue().get("String");
        Assert.assertNull(expireValue);

        //获取旧值并设置新值
        template.opsForValue().set("getAndSet", "Old");
        Object oldValue = template.opsForValue().getAndSet("getAndSet", "new");
        Object newValue = template.opsForValue().get("getAndSet");
        Assert.assertEquals("Old", oldValue);
        Assert.assertEquals("new", newValue);

        Boolean delRes = template.delete("getAndSet");
        Assert.assertNotNull(delRes);
        Assert.assertTrue(delRes);
    }

    @Test
    public void testRedisCommand() throws InterruptedException {
        // 使用redisTemplate使用redis命令  $ SET abc 123 EX 10 NX
        // 命令参考redis.clients.jedis.Protocol.Command中定义
        template.execute((RedisCallback<Object>) connection -> connection.execute(
                "SET",
                "abc".getBytes(),
                "123".getBytes(),
                "EX".getBytes(),
                "10".getBytes(),
                "NX".getBytes()
                ));
        Object abc = template.opsForValue().get("abc");
        Assert.assertEquals(123, abc);
        Thread.sleep(11 * 1000);
        Boolean res = template.hasKey("abc");
        Assert.assertNotNull(res);
        Assert.assertFalse(res);
    }

    @Test
    public void incrementTest(){
        template.opsForValue().set("int", 1);
        // 整数加法
        Long res = template.opsForValue().increment("int", 2);
        Assert.assertNotNull(res);
        Assert.assertEquals(3, res.longValue());

        // 整数减法
        res = template.opsForValue().increment("int", -1L);
        Assert.assertNotNull(res);
        Assert.assertEquals(2, res.longValue());

        //浮点数加法
        template.opsForValue().set("float", 1.2);
        Double res2 = template.opsForValue().increment("float", 1.3);
        Assert.assertNotNull(res2);
        Assert.assertEquals(2.5, res2, 0.0);

        res2 = template.opsForValue().increment("float", -1.0);
        Assert.assertNotNull(res2);
        Assert.assertEquals(1.5, res2, 0.0);

        template.delete(Arrays.asList("int", "float"));

    }
}
