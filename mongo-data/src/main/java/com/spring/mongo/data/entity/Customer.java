package com.spring.mongo.data.entity;

import org.springframework.data.annotation.Id;

/**
 *                       
 * @Filename Customer.java
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
public class Customer {
	@Id
	String id;
	
	String firstName;
	String lastName;
	public Customer() {
	}
	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return String.format("Customer[id=%s,firstName=%s,lastName=%s]", id,firstName,lastName);
	}
}
