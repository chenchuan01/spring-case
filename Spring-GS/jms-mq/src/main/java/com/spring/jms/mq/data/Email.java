package com.spring.jms.mq.data;
/**
 *                       
 * @Filename Email.java
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
public class Email {
	private String to;
	private String body;
	public Email() {
		super();
	}
	public Email(String to, String body) {
		super();
		this.to = to;
		this.body = body;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	};
	
	@Override
	public String toString() {
		return String.format("Email{to=%s,body=%s}", getTo(),getBody());
	}
}
