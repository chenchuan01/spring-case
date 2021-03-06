package com.spring.restful.actuator;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.BDDAssertions.then;
/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=App.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties={"management.port=0"})
public class AppTest {
	@LocalServerPort
	private int port;
	
	@Value("${local.management.port}")
	private int mgt;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void apiServTest() throws Exception{
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity= restTemplate.getForEntity("http://localhost:"+port+"/hello-world", Map.class);
		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	@Test
	public void mngServTest() throws Exception{
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity= restTemplate.getForEntity("http://localhost:"+mgt+"/info", Map.class);
		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
