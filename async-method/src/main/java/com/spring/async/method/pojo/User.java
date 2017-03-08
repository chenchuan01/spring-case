package com.spring.async.method.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *                       
 * @Filename User.java
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
@JsonIgnoreProperties(ignoreUnknown=true)
public class User {
	private String name;
	private String blog;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBlog() {
		return blog;
	}
	public void setBlog(String blog) {
		this.blog = blog;
	}
	
	@Override
	public String toString() {
		return String.format("GitHub User [name=%s,blog=%s]", name,blog);
	}
}
