package com.yoke.client.listener;

import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Service
public class MyMessageListener implements MessageListener {
    public void onMessage(Message message) {
        try {
            message.acknowledge();
            System.out.println(((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
