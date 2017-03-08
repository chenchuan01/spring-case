package com.spring.web.socket.pojo;
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
 *<li>Date: 2017年3月6日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class Greeting {
	private String content;

	public Greeting() {
	}
	
	public Greeting(String content) {
		super();
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
