package com.spring.boot.mysql;
/**
 *                       
 * @Filename BaseEntity.java
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
 *<li>Date: 2017年3月13日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity implements Serializable {
	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = 1886754123410605245L;
	
	
	int status=0;
	
	public BaseEntity() {
	}
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
