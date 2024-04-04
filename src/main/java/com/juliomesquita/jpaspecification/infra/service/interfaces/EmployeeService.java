package com.juliomesquita.jpaspecification.infra.service.interfaces;

import com.juliomesquita.jpaspecification.infra.data.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface EmployeeService {

    Page<Employee> findBySearchCriteria(Specification<Employee> spec, Pageable pageable);
}
