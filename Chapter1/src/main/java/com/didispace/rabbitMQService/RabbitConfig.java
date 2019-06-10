package com.didispace.rabbitMQService;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by v-yangxu on 2019/4/22.
 * rabbitMq配置
 * 用来配置队列、交换器、路由等高级信息
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue helloQueue(){
        return  new Queue("hello");
    }
}
