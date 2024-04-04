package com.juliomesquita.jpaspecification.infra.data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @Table(name = "departament")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Departament {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departament_id", nullable = false)
    private Long id;

    @Column(name = "departament_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "departament")
    private List<Employee> employees;
}
