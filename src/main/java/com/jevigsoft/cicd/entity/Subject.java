package com.jevigsoft.cicd.entity;

import com.jevigsoft.cicd.enums.common.ActiveStatus;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String subjectId;

    @Column(nullable = false, unique = false)
    private String subjectName;

    @Enumerated(value = EnumType.STRING)
    private ActiveStatus status;

    @OneToMany(mappedBy = "subject")
    @ToString.Exclude
    private List<CourseSubject> courseSubjects;

}
