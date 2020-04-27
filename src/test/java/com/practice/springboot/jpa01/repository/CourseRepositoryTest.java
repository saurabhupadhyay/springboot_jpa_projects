package com.practice.springboot.jpa01.repository;

import com.practice.springboot.jpa01.Application;
import com.practice.springboot.jpa01.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CourseRepositoryTest {
private Logger LOG= LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepository repository;

	@Test
	@DirtiesContext
	public void test_deleteById() throws Exception {
		Long courseId=10001L;
		repository.deleteById(courseId);
		Course course= repository.findById(courseId);
		assertNull(course);
	}

	@Test
	public 	void test_findById() {
		Long courseId=10001L;
		Course course= repository.findById(courseId);
		assertEquals("Test Course",course.getName());
		assertNotNull(course);
		LOG.info("Test is running ");
	}

	@Test
	public void test_save() throws Exception {
		Course course=repository.findById(10001L);
		assertEquals("Spring Boot in 100 Steps.",course.getName());
		course.setName("Spring Boot in 100 Steps - Updated");
		repository.save(course);
		Course course1=repository.findById(10001L);
		assertEquals("Spring Boot in 100 Steps - Updated",course1.getName());
	}

	@Test
	public void test_playWithEntityManager() throws Exception {
		repository.playWithEntityManager();
	}
}