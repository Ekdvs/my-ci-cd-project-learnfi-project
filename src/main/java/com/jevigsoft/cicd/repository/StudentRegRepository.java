package com.jevigsoft.cicd.repository;

import com.jevigsoft.cicd.entity.StudentReg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRegRepository extends JpaRepository<StudentReg, Long> {

}
