package com.spring.rabbitmq.pojo;

import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

/**
 *                       
 * @Filename Receiver.java
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
 *<li>Date: 2017年2月20日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@Component
public class Receiver {
	private CountDownLatch latch = new CountDownLatch(1);
	
	public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
