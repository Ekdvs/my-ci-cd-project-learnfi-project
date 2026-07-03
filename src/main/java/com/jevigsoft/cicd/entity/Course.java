package com.jevigsoft.cicd.entity;


import com.jevigsoft.cicd.enums.common.ActiveStatus;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String courseId;

    @Column(nullable = false, unique = true)
    private String courseName;

    @Column(nullable = false)
    private BigDecimal courseFee;

    @Enumerated(value = EnumType.STRING)
    private ActiveStatus status;

    @OneToMany(mappedBy = "course")
    @ToString.Exclude
    private List<Batch> batches;

    @OneToMany(mappedBy = "course")
    @ToString.Exclude
    private List<CourseSubject> courseSubjects;

}
