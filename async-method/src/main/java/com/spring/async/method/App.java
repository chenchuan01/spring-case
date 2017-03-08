package com.spring.async.method;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableAsync
public class App extends AsyncConfigurerSupport {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Override
	public Executor getAsyncExecutor(){
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("GitHubLookUp-");
		executor.initialize();
		return executor;
	}
}
