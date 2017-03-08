package com.spring.web.socket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.spring.web.socket.pojo.Greeting;
import com.spring.web.socket.pojo.HelloMessage;

/**
 *                       
 * @Filename GreetingController.java
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
 *<li>Author: chenchuan</li>
 *<li>Date: 2017年3月6日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */

@Controller
public class GreetingController {
	
	
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greet(HelloMessage message) throws InterruptedException{
		Thread.sleep(1000);
		return new Greeting(String.format("Hello, %s !", message.getName()));
	}
}
