package com.jevigsoft.cicd.repository;


import com.jevigsoft.cicd.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {


}
