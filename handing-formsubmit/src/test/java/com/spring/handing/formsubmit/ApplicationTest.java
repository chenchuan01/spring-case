package com.spring.handing.formsubmit;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * 
 * @Filename ApplicationTest.java
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

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "logging.level.org.springframework.web=DEBUG")
@AutoConfigureMockMvc
public class ApplicationTest {
	@Autowired
	MockMvc mockMvc;

	@Test
	public void resetForm() throws Exception {
		mockMvc.perform(get("/greeting")).andExpect(content().string(containsString("Form")));
	}

	@Test
	public void submitsForm() throws Exception {
		mockMvc.perform(post("/greeting").param("id", "123456").param("content", "unit test"))
				.andExpect(content().string(containsString("id: 123456")));
	}
}
