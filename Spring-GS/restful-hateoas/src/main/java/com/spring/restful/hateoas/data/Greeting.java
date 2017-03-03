package com.spring.restful.hateoas.data;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *                       
 * @Filename Greeting.java
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
public class Greeting extends ResourceSupport {
	private final String content;
	@JsonCreator
	public Greeting(@JsonProperty("content") String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	
}
