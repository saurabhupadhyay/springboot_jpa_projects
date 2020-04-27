package com.practice.springboot.jpa01.repository;


import com.practice.springboot.jpa01.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {
    @Autowired
    private EntityManager em;

    public Course findById(Long courseId){
        return  em.find(Course.class,courseId);
    }


    public void deleteById(long courseId) {
        Course course=findById(courseId);
                 em.remove(course);
    }

    public Course save(Course course){
        if (null==course.getId()){
            em.persist(course);
        }else{
            em.merge(course);
        }
        return course;
    }

    public void  playWithEntityManager(){
        Course course1=new Course("WebService in 100 Steps");
        save(course1);
        Course course2=new Course("Angular JS in 100 Steps");
        save(course2);
        em.flush();
       /* em.detach(course1);
        em.detach(course2);*/
    //   em.clear();

        System.out.println("is course1 in em :"+em.contains(course1));

        course1.setName("WebService in 100 Steps-Updated");
        course2.setName("Angular JS in 100 Steps-Updated");
        em.refresh(course1);
        em.flush();
    }
}