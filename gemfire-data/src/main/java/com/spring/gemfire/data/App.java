package com.spring.gemfire.data;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import com.gemstone.gemfire.cache.GemFireCache;
import com.spring.gemfire.data.entity.Person;
import com.spring.gemfire.data.repos.PersonRepository;

/**
 * Hello world!
 *
 */
@Configuration
@EnableGemfireRepositories
public class App implements CommandLineRunner{
	
	@Bean
	Properties gemfrieProperties(){
		Properties gemfireProperties= new Properties();
		gemfireProperties.setProperty("name", "DataGemFireApplication");
		gemfireProperties.setProperty("mcast-port", "0");
		gemfireProperties.setProperty("log-level", "config");
		return gemfireProperties;
	}
	@Bean
	CacheFactoryBean gemfireCache(){
		CacheFactoryBean gemfireCache = new CacheFactoryBean();
		gemfireCache.setClose(true);
		gemfireCache.setProperties(gemfrieProperties());
		return gemfireCache;
	}
	@Bean
	LocalRegionFactoryBean<String, Person> helloRegin(final GemFireCache cache){
		LocalRegionFactoryBean<String, Person> helloRegin = new LocalRegionFactoryBean<>();
		helloRegin.setCache(cache);
		helloRegin.setClose(false);
		helloRegin.setName("person");
		helloRegin.setPersistent(false);
		return helloRegin;
	}
	@Autowired
    PersonRepository personRepository;
	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(App.class);
		application.setWebEnvironment(false);
		application.run(args);
	}



	@Override
	public void run(String... args) throws Exception {
		 	Person alice = new Person("Alice", 40);
	        Person bob = new Person("Baby Bob", 1);
	        Person carol = new Person("Teen Carol", 13);

	        System.out.println("Before linking up with Gemfire...");
	        for (Person person : new Person[] { alice, bob, carol }) {
	            System.out.println("\t" + person);
	        }

	        personRepository.save(alice);
	        personRepository.save(bob);
	        personRepository.save(carol);

	        System.out.println("Lookup each person by name...");
	        for (String name : new String[] { alice.getName(), bob.getName(), carol.getName() }) {
	            System.out.println("\t" + personRepository.findByName(name));
	        }

	        System.out.println("Adults (over 18):");
	        for (Person person : personRepository.findByAgeGreaterThan(18)) {
	            System.out.println("\t" + person);
	        }

	        System.out.println("Babies (less than 5):");
	        for (Person person : personRepository.findByAgeLessThan(5)) {
	            System.out.println("\t" + person);
	        }

	        System.out.println("Teens (between 12 and 20):");
	        for (Person person : personRepository.findByAgeGreaterThanAndAgeLessThan(12, 20)) {
	            System.out.println("\t" + person);
	        }
	}
}
