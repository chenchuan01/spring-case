package com.spring.rabbitmq;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.spring.rabbitmq.pojo.Receiver;

/**
 * 
 * @Filename Runner.java
 *
 * @Description
 *
 * @Version 1.0
 *
 * @Author chenchuan
 *
 * @Email 329985581@qq.com
 * 
 * @History
 * 			<li>Author: chenchuan</li>
 *          <li>Date: 2017年2月20日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
@Component
public class Runner implements CommandLineRunner {
	private RabbitTemplate rabbitTemplate;
	private Receiver receiver;
	private ConfigurableApplicationContext context;

	public Runner(RabbitTemplate rabbitTemplate, Receiver receiver, ConfigurableApplicationContext applicationContext) {
		super();
		this.rabbitTemplate = rabbitTemplate;
		this.receiver = receiver;
		this.context = applicationContext;
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("Sending message...");
		rabbitTemplate.convertAndSend(App.queueName, "Hello from RabbitMQ!"+new Random(System.currentTimeMillis()).nextInt());
		receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
		context.close();
	}

}
