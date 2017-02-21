package com.spring.validate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AppTest {
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void checkNotNull() throws Exception{
		MockHttpServletRequestBuilder personForm= post("/").param("age", "20");
		mockMvc.perform(personForm).andExpect(model().hasErrors());
	}
	
	@Test 
	public void checkLength() throws Exception{
		MockHttpServletRequestBuilder personForm=post("/").param("name", "1").param("age", "17");
		mockMvc.perform(personForm).andExpect(model().hasErrors());
	}
	
}
