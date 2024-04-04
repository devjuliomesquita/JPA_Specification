package com.juliomesquita.jpaspecification.infra.data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity @Table(name = "salary_grade")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SalaryGrade {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salary_grade_id", nullable = false)
    private Long id;

    @Column(name = "salary_grade_min")
    private BigDecimal minSalary;

    @Column(name = "salary_grade_max")
    private BigDecimal maxSalary;
}
