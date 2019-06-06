package com.didispace.rabbitMQService;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by v-yangxu on 2019/4/22.
 * 消息接收者
 */
@Component
@RabbitListener(queues = "hello")//监听消息队列hello
public class Recevier {

    @RabbitHandler//处理消息
    public void process(String hello){
        System.out.println("Recevier:"+hello);
        System.out.println("Recevier:"+hello);
        System.out.println("Recevier:"+hello);
        System.out.println("Recevier:"+hello);
    }

}
