package com.spring.restful.actuator.ctl;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.restful.actuator.data.Greeting;

/**
 *                       
 * @Filename HelloController.java
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
@Controller
@RequestMapping("/hello-world")
public class HelloController {
	private static final String template="Hello, %s!";
	private static final AtomicLong count = new AtomicLong();
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Greeting say(@RequestParam(value="name",required=false,defaultValue="Spring Actuator Restful") String name){
		return new Greeting(count.incrementAndGet(), String.format(template, name));
	}
}
