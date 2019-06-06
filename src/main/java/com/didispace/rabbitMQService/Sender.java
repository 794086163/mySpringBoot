package com.didispace.rabbitMQService;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by v-yangxu on 2019/4/22.
 * 消息发送者
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context="hello "+new Date();
        System.out.println("send:"+context);
        rabbitTemplate.convertAndSend("hello",context);
    }
}
