package com.juliomesquita.jpaspecification.infra.data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity @Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private Long id;

    @Column(name = "employee_firstname", nullable = false)
    private String firstname;

    @Column(name = "employee_lastname", nullable = false)
    private String lastname;

    @Column(name = "employee_job_name", nullable = false)
    private String jobName;

    @Column(name = "employee_manager_id")
    private Long managerId;

    @Column(name = "employee_hiredt", nullable = false)
    private Date hiredt;

    @Column(name = "employee_salary", nullable = false)
    private BigDecimal salary;

    @Column(name = "employee_commission")
    private BigDecimal commission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departament_id", referencedColumnName = "departament_id")
    private Departament departament;
}
