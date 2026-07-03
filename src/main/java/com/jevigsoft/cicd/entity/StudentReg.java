package com.jevigsoft.cicd.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StudentReg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal regFee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Batch batch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Student student;

    @JsonFormat(pattern = "dd-MM-yyyy HH:MM:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @OneToMany(mappedBy = "studentReg")
    @ToString.Exclude
    private List<Attendance> attendances;

}
