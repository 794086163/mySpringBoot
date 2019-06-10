package com.didispace.rabbitMQService;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class RecvMQ {

	private final static String QUEUE_NAME = "Hello";

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setPort(5672);
		factory.setUsername("guest");
		factory.setPassword("guest");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		//读取消息，为阻塞状态，当有新消息时，会立即读取新消息
		Consumer consumer = new DefaultConsumer(channel) {
			
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message=new String(body,"UTF-8");
				System.out.println("[X]Received'"+message+"'");
				
			};
		};
		channel.basicConsume(QUEUE_NAME, true,consumer);
	}
}
