package com.spring.restful;

import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 * 程序入口
 */
@SpringBootApplication
public class App {
	
	@Bean
	public void getuser(){
		System.out.println("test init bean");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
