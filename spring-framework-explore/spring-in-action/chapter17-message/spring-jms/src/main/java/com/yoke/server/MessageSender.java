package com.yoke.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {

    @Autowired
    private JmsOperations jmsOperations;

    public void send(){
        jmsOperations.convertAndSend("my_queue", "I'm a message!");
    }
}
