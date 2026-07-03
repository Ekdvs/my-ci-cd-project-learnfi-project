package com.jevigsoft.cicd.repository;


import com.jevigsoft.cicd.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {


}
