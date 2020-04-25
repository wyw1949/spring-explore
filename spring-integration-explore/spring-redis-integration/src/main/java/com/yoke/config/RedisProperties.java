package com.yoke.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.Topic;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@PropertySource("classpath:redis.properties")
@Component
@Data
public class RedisProperties{

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private Integer port;

    private Map<MessageListener, Collection<? extends Topic>> messageListeners = new HashMap<>();

}
