package com.spring.rabbit.mq;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.rabbit.mq.App;
import com.spring.rabbit.mq.Runner;
import com.spring.rabbit.mq.pojo.Receiver;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest extends TestCase {
	@MockBean
	Runner runner;
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Autowired
	Receiver receiver;
	
	@Test
	public void test() throws InterruptedException{
		 rabbitTemplate.convertAndSend(App.queueName, "Hello from RabbitMQ!");
	     receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
	}
}
