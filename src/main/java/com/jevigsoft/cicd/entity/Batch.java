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
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String batchId;

    @Column(nullable = false, unique = true)
    private String batchNo;

    @Enumerated(value = EnumType.STRING)
    private ActiveStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Course course;

    @OneToMany(mappedBy = "batch")
    @ToString.Exclude
    private List<StudentReg> studentRegs;
}
