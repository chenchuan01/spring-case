package com.spring.restful.data;
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
 *<li>Date: 2017年2月20日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class Greeting {
	private  Long id;
	private String content;
	public Greeting() {
		super();
	}
	
	public Greeting(Long id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
