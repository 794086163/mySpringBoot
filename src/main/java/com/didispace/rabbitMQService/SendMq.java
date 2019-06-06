package com.didispace.rabbitMQService;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class SendMq {
	private final static String QUEUE_NAME = "Hello";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		/*
		 * Connection是socket连接的抽象，并且为我们管理协议版本协商
		 * 认证等等事情。这里我们要连接的消息代理在本地，因此我们将host设为
		 * "localhost",如果我们想连接其他机器上的代理，只需要将这里改为待定
		 * 的主机名或ip地址
		 */
		ConnectionFactory factory =new ConnectionFactory();
		factory .setHost("localhost");
		factory .setPort(5672);
		factory .setPassword("guest");
		factory .setUsername("guest");
		Connection connect=factory.newConnection();
		Channel channel=connect.createChannel();
		// 接下来，我们创建一个channel，绝大部分API方法需要通过调用它来完成。
        // 发送之前，我们必须声明消息要发往哪个队列，然后我们可以向队列发一条消息：
		channel.queueDeclare(QUEUE_NAME , false, false, false, null);//创建队列
		String message = "Hello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world2Hello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello worldHello world";
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		System.out.println("[X]send'"+message+"'");
		channel.close();
		connect.close();
	}
}
