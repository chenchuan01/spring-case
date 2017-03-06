package com.spring.batch.serv.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 *                       
 * @Filename PersonItemProcessor.java
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
 *<li>Date: 2017年2月21日</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class PersonItemProcessor implements ItemProcessor<Person, Person> {
	private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);
	@Override
	public Person process(final Person person) throws Exception {
		final String lastName = person.getLastName();
		final String firstName= person.getFirstName();
		final Person transformedPerson = new Person(lastName, firstName);
		log.info("Converting ("+person+") into ("+transformedPerson+")");
		return transformedPerson;
	}

}
