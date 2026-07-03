package com.jevigsoft.cicd.entity;


import com.jevigsoft.cicd.enums.common.ActiveStatus;
import com.jevigsoft.cicd.enums.common.UserRole;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Navishka Darshana - navishka@learnfi.lk
 * @project my-cicd-project
 * @CreatedBy IntelliJ IDEA
 * @created 19/01/2024 - 18.59
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false, unique = true)
    private String password;
    private int filedLoginAttemptCount;
    @Column(nullable = true)
    private String mobile;


    @JsonFormat(pattern = "dd-MM-yyyy HH:MM:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogOutTimestamp;

    @JsonFormat(pattern = "dd-MM-yyyy HH:MM:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @JsonFormat(pattern = "dd-MM-yyyy HH:MM:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    @Enumerated(value = EnumType.STRING)
    private ActiveStatus status;

    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

}
