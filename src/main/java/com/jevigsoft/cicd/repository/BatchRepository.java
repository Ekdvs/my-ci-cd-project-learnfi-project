package com.jevigsoft.cicd.repository;


import com.jevigsoft.cicd.entity.Batch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {


}
