package com.practice.springboot.jpa01;

import com.practice.springboot.jpa01.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by SANDY on 30-12-2019.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class GeneralTest {
    @Test
    public void testName() throws Exception {
        Configuration cfg=new Configuration().configure().addAnnotatedClass(Course.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        Course c1=session.load(Course.class,1);
        System.out.println(c1);
    }
}
