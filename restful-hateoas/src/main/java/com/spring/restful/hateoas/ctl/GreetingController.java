package com.spring.restful.hateoas.ctl;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restful.hateoas.data.Greeting;

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
 *<li>Date: 2017年3月3日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@RestController
public class GreetingController {
	private static final String TEMPLATE="Hello,%s!";
	
	@RequestMapping("/greeting")
	public HttpEntity<Greeting> greet(@RequestParam(value="name",required=false,defaultValue="world") String name){
		Greeting greeting = new Greeting(String.format(TEMPLATE, name));
		greeting.add(linkTo(methodOn(GreetingController.class).greet(name)).withSelfRel());
		
		return new ResponseEntity<Greeting>(greeting,HttpStatus.OK);
	}
}
