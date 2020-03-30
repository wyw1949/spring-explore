package com.yoke;

import com.yoke.client.MessageReceiver;
import com.yoke.config.ActiveMQConfig;
import com.yoke.server.MessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ActiveMQConfig.class})
public class ActiveMQTest {

    @Autowired
    private MessageSender sender;

    @Autowired
    private MessageReceiver receiver;

    @Test
    public void send() throws InterruptedException {
        sender.send();
        Thread.sleep(3000);
    }

    @Test
    public void receive(){
        receiver.receive();
    }
}
