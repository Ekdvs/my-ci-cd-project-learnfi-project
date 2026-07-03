package com.jevigsoft.cicd.repository;


import com.jevigsoft.cicd.entity.CourseSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseSubjectRepository extends JpaRepository<CourseSubject, Long> {


}
