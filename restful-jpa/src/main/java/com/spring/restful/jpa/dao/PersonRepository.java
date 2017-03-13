package com.spring.restful.jpa.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.restful.jpa.entity.Person;

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
 *<li>Author: chenchuan</li>
 *<li>Date: 2017年3月13日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>{
	List<Person> findByLastName(@Param("name") String name);
}
