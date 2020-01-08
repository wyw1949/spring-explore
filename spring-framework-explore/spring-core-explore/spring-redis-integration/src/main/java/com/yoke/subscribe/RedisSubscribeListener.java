package com.yoke.subscribe;

import com.yoke.config.RedisProperties;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.Topic;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * redis的发布/订阅功能
 * 实现{@link MessageListener}, 在{@see MessageListener#onMessage}处理监听到的消息
 * {@link MessageListener} 要注册在{@link org.springframework.data.redis.listener.RedisMessageListenerContainer}
 * 中才会生效。RedisMessageListenerContainer需要一个Map<? extends MessageListener, Collection<? extends Topic>>
 *  Topic 指订阅的主题，支持两种topic
 *  {@link ChannelTopic} 确定名称，比如:"chat"，可类比rabbitMQ的direct
 *  {@link PatternTopic} 模糊匹配，比如："chat*", 可类比rabbitMQ的topic
 *
 */
@Component
public class RedisSubscribeListener implements MessageListener, InitializingBean {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedisProperties properties;

    /**
     * 在这里取到监听到的消息
     * @param message 消息体，可以从中获取channel和message body
     * @param pattern 路由键
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {

        Object patt = redisTemplate.getStringSerializer().deserialize(pattern);
        System.out.println("pattern: " + patt);

        Object body = redisTemplate.getValueSerializer().deserialize(message.getBody());
        System.out.println("body: " + body);

        String channel = redisTemplate.getStringSerializer().deserialize(message.getChannel());
        System.out.println("channel: " + channel);
    }

    /**
     * 此处便于扩展，采用工厂模式，将MessageListener实例缓存到{@link RedisProperties#getMessageListeners()}中
     * 在{@link com.yoke.config.RedisConfig#redisMessageListenerContainer(JedisConnectionFactory)} 中，将
     * messageListeners注册到redisMessageListenerContainer中
     */
    @Override
    public void afterPropertiesSet() {
        List<Topic> topics = new ArrayList<>();
        topics.add(new PatternTopic("chat*"));
        properties.getMessageListeners().put(this, topics);
    }
}
