package com.yoke.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@ComponentScan(basePackages = "com.yoke")
public class RedisConfig {

    @Autowired
    private RedisProperties properties;

    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        //创建连接池，类似连接数据库使用的数据源
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(50);
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setMaxWaitMillis(20000);
        return jedisPoolConfig;
    }

    @Bean
    public JedisConnectionFactory factory(JedisPoolConfig jedisPoolConfig){
        //　创建连接工厂
        JedisConnectionFactory factory = new JedisConnectionFactory(jedisPoolConfig);
        factory.setHostName(properties.getHost());
        factory.setPort(properties.getPort());
        return factory;
    }

    @Bean
    public RedisTemplate<String, ?> redisTemplate(JedisConnectionFactory factory){
        // 创建redisTemplate操作redis
        RedisTemplate<String, ?> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        // 设置key序列化器
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置值序列化器
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        /*
        对于hash的值是键值对的形式，所以对hash数据值的key和value也需要设置相应的序列化器
         */
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        // 检查是有配置了连接工厂，并且对没有设置序列化器的设置默认序列化器JdkSerializationRedisSerializer
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /**
     * RedisMessageListenerContainer需要线程池来监听订阅的redis的消息。
     * 需要注意的是在创建线程池后要初始化它，否则将报错
     * @param factory redis 连接工厂
     * @return RedisMessageListenerContainer实例
     */
    @Bean(destroyMethod = "destroy")
    public RedisMessageListenerContainer redisMessageListenerContainer (JedisConnectionFactory factory){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);
        container.setMessageListeners(properties.getMessageListeners());
        ThreadPoolTaskScheduler taskExecutor = new ThreadPoolTaskScheduler();
        taskExecutor.setPoolSize(3);
        // 初始化线程池，否则报错
        taskExecutor.initialize();
        container.setTaskExecutor(taskExecutor);
        return container;
    }
}
