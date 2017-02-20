package com.spring.restful.ctl;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restful.data.Greeting;

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
 *<li>Date: 2017年2月20日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@RestController
@RequestMapping("/greet")
public class GreetingController {
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
	@RequestMapping("/say")
	public Greeting say(@RequestParam(name="name",defaultValue="world") String name){
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
