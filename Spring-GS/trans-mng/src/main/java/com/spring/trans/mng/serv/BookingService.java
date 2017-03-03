package com.spring.trans.mng.serv;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *                       
 * @Filename BookingService.java
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
 *<li>Date: 2017年3月3日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@Component
public class BookingService {
	private final static Logger logger = LoggerFactory.getLogger(BookingService.class);
	
	private final  JdbcTemplate jdbcTemplate;
	
	public BookingService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	/** 
	 * <p>标题: book</p>	
	 * <p>说明: 执行步骤中若存在失败，事务将会自动回滚</p>	
	 * <p>作者: chenchuan
	 * <p>时间: 2017年3月3日</p>
	 * @param persons
	 */
	@Transactional
	public void book(String... persons){
		for (String person : persons) {
			logger.info(String.format("Booking %s in a seat", person));
			jdbcTemplate.update("insert into BOOKINGS(FIRST_NAME) values (?)",person);
		}
	}
	
	public List<String> findAllBookings(){
		return jdbcTemplate.query("select FIRST_NAME from BOOKINGS", (rs,rowNum)->rs.getString("FIRST_NAME"));
	}
}
