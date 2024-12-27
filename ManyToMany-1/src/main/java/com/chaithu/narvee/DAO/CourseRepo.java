package com.chaithu.narvee.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chaithu.narvee.Entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

}
