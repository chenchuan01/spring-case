package com.spring.restful;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 *                       
 * @Filename GreetCtlTest.java
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
 *<li>Date: 2017年2月20日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GreetCtlTest {
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void noParam(){
		try {
			mockMvc.perform(get("/greet/say")).andDo(print()).andExpect(status().is2xxSuccessful())
			.andExpect(jsonPath("$.content").value("Hello, world!"));
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	@Test
	public void withPatam(){
		try {
			mockMvc.perform(get("/greet/say").param("name", "xiaochuan"))
			.andExpect(jsonPath("$.content").value("Hello, xiaochuan!"));
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
