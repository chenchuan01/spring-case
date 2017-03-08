package com.spring.async.method.service;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.async.method.pojo.User;

/**
 * 
 * @Filename GitHubLookUpService.java
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
 *          <li>Date: 2017年3月6日</li>
 *          <li>Version: 1.0</li>
 *          <li>Content: create</li>
 *
 */
@Service
public class GitHubLookUpService {
	private static final Logger logger = LoggerFactory.getLogger(GitHubLookUpService.class);
	private final RestTemplate restTemplate;

	public GitHubLookUpService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@Async
	public Future<User> findUser(String user) throws InterruptedException {
		logger.info("Looking up " + user);
		String url = String.format("https://api.github.com/users/%s", user);
		User results = restTemplate.getForObject(url, User.class);
		// Artificial delay of 1s for demonstration purposes
		Thread.sleep(1000L);
		return new AsyncResult<>(results);
	}

}
