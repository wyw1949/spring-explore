package com.yoke.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Service;

@Service
public class MessageReceiver {

    @Autowired
    private JmsOperations jmsOperations;

    public void receive(){
        Object queue = jmsOperations.receiveAndConvert("my_queue");
        System.out.println("接收到消息：" + String.valueOf(queue));
    }
}
