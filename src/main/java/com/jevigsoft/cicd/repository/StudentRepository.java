package com.jevigsoft.cicd.repository;


import com.jevigsoft.cicd.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
