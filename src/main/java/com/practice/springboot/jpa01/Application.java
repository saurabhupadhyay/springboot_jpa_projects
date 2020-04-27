package com.practice.springboot.jpa01;

import com.practice.springboot.jpa01.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private Logger log= LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
	//	Course course=repository.findById(10001L);
	//	log.info("course{}",course);
		//repository.deleteById(10001L);
		repository.playWithEntityManager();
	}
}
