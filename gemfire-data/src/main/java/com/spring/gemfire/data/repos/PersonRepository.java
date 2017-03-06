package com.spring.gemfire.data.repos;

import org.springframework.data.repository.CrudRepository;

import com.spring.gemfire.data.entity.Person;

/**
 * 
 * @Filename PersonRepository.java
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
public interface PersonRepository extends CrudRepository<Person, String> {
	Person findByName(String name);

	Iterable<Person> findByAgeGreaterThan(int age);

	Iterable<Person> findByAgeLessThan(int age);

	Iterable<Person> findByAgeGreaterThanAndAgeLessThan(int age1, int age2);
}
