package com.spring.rabbit.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.rabbit.mq.pojo.Receiver;



/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {
	public static final String queueName="spring-boot";
	
	@Bean
	Queue queue(){
		return new Queue(queueName, false);
	}
	
	@Bean
	TopicExchange exchange(){
		return new TopicExchange("spring-boot-exchange");
	}
	
	@Bean
	Binding binding(Queue queue,TopicExchange exchange){
		return BindingBuilder.bind(queue).to(exchange).with(queueName);
	}
	
	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,MessageListenerAdapter listenerAdapter){
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setMessageListener(listenerAdapter);
		container.setQueueNames(queueName);
		return container;
	}
	/** 
	 * <p>标题: listenerAdapter</p>	
	 * <p>说明: 消息监听适配</p>	
	 * <p>作者: chenchuan
	 * <p>时间: 2017年2月20日</p>
	 * @param receiver
	 * 			消息监听组件  
	 * 		  receiveMessage
	 * 			组件中实现消息监听方法
	 * @return
	 */
	@Bean
	MessageListenerAdapter listenerAdapter(Receiver receiver){
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
