package com.spring.jpa.data.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.jpa.data.entity.Customer;

/**
 * 
 * @Filename CustomerRepository.java
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
 * 			<li>Author: chenchuan</li>
 *          <li>Date: 2017年3月3日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByLastName(String lastName);
}
