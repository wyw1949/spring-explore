package com.yoke.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.MessageListener;

@Configuration
@ComponentScan("com.yoke")
public class ActiveMQConfig {

    // 配置activemq链接工厂
    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory(){
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
        activeMQConnectionFactory.setUserName("admin");
        activeMQConnectionFactory.setPassword("admin");
        return activeMQConnectionFactory;
    }

    @Bean
    public ActiveMQQueue queue(){
        ActiveMQQueue queue = new ActiveMQQueue();
        queue.setPhysicalName("my_queue");
        return queue;
    }

   @Bean
   public JmsOperations jmsOperations(){
       JmsTemplate jmsOperation = new JmsTemplate();
        jmsOperation.setConnectionFactory(activeMQConnectionFactory());
        jmsOperation.setDefaultDestination(new ActiveMQQueue("my_default"));
        return jmsOperation;
   }

   @Bean
    public DefaultMessageListenerContainer listenerContainer(MessageListener myMessageListener){
       DefaultMessageListenerContainer listenerContainer = new
               DefaultMessageListenerContainer();
       listenerContainer.setMessageListener(myMessageListener);
       listenerContainer.setConnectionFactory(activeMQConnectionFactory());
       listenerContainer.setDestination(queue());
       return listenerContainer;
   }
}
