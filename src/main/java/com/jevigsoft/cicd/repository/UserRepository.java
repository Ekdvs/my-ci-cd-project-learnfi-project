package com.jevigsoft.cicd.repository;

import com.jevigsoft.cicd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Navishka Darshana - navishka@learnfi.lk
 * @project my-cicd-project
 * @CreatedBy IntelliJ IDEA
 * @created 11/07/2024 - 11.57
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
