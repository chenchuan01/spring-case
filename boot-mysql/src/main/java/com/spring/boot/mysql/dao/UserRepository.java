package com.spring.boot.mysql.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.mysql.entity.User;

/**
 *                       
 * @Filename UserRepository.java
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
public interface UserRepository extends CrudRepository<User, Long>{
}
