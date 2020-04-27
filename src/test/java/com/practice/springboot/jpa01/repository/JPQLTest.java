package com.practice.springboot.jpa01.repository;

import com.practice.springboot.jpa01.Application;
import com.practice.springboot.jpa01.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class JPQLTest {
private Logger LOG= LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;

	@Test
	public void test_jpql_query() throws Exception {
		Query query = em.createQuery(" Select  c  from Course  c");
		List resultList= query.getResultList();
		LOG.info("result>>"+resultList);
	}

	@Test
	public void test_jpql_typed_query() throws Exception {
		TypedQuery<Course> typedQuery = em.createQuery(" Select  c  from Course  c", Course.class);
		List<Course> resultList= typedQuery.getResultList();
		LOG.info("result---->>"+resultList);
	}

	@Test
	public void test_jpql_where_query() throws Exception {
		TypedQuery<Course> typedQuery = em.createQuery(" Select  c  from Course  c", Course.class);
		List<Course> resultList= typedQuery.getResultList();
		LOG.info("result---->>"+resultList);
	}

}