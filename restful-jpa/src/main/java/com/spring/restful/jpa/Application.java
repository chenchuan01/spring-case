package com.spring.restful.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.restful.jpa.entity.Person;

@SpringBootApplication
public class Application {
	@Bean
	public Person getuser(){
		System.out.println("test init bean.......................");
		return new Person();
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
