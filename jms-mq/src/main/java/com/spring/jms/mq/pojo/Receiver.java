package com.spring.jms.mq.pojo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.spring.jms.mq.data.Email;

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
 *<li>Date: 2017年2月21日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@Component
public class Receiver {
	@JmsListener(destination="mailBox",containerFactory="mailFactory")
	public void receiveMessage(Email email){
		System.out.println("Receive <"+email+">");
	}
}
