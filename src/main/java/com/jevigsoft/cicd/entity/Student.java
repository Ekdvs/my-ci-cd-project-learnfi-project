package com.jevigsoft.cicd.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.jevigsoft.cicd.enums.common.AccountVerifyStatus;
import com.jevigsoft.cicd.enums.common.ActiveStatus;
import com.jevigsoft.cicd.enums.common.UserRole;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    private String password;

    @JsonFormat(pattern = "dd-MM-yyyy HH:MM:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;

    private int age;
    private String nic;

    private String studentNo;
    private String srId;
    private int filedLoginAttemptCount;

    @Column(nullable = false)
    private String mobile;
    @Lob
    private String address;

    @Enumerated(value = EnumType.STRING)
    private ActiveStatus status;

    @Enumerated(value = EnumType.STRING)
    private AccountVerifyStatus account_verify_status;

    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;

    @JsonFormat(pattern = "dd-MM-yyyy HH:MM:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date email_verify_link_timestamp;

    @JsonFormat(pattern = "dd-MM-yyyy HH:MM:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogOutTimestamp;

    @JsonFormat(pattern = "dd-MM-yyyy HH:MM:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @JsonFormat(pattern = "dd-MM-yyyy HH:MM:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    private List<StudentReg> studentRegs;
}
