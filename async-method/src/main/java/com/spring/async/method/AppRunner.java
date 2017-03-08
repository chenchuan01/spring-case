package com.spring.async.method;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.async.method.pojo.User;
import com.spring.async.method.service.GitHubLookUpService;

/**
 *                       
 * @Filename AppRunner.java
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
@Component
public class AppRunner implements CommandLineRunner {
	private static final Logger logger=LoggerFactory.getLogger(AppRunner.class);
	
	private final GitHubLookUpService gitHubLookUpService;
	
	public AppRunner(GitHubLookUpService gitHubLookUpService) {
		this.gitHubLookUpService=gitHubLookUpService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		long start = System.currentTimeMillis();
		
		Future<User> page1= gitHubLookUpService.findUser("PivotalSoftware");
		Future<User> page2= gitHubLookUpService.findUser("CloudFoundry");
		Future<User> page3= gitHubLookUpService.findUser("Spring-Projects");
		
		while (!(page1.isDone()&&page2.isDone()&&page3.isDone())) {
			Thread.sleep(10);
		}
		
		 // Print results, including elapsed time
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        logger.info("--> " + page1.get());
        logger.info("--> " + page2.get());
        logger.info("--> " + page3.get());
	}

}
