package com.juliomesquita.jpaspecification.infra.service;

import com.juliomesquita.jpaspecification.infra.data.entities.Employee;
import com.juliomesquita.jpaspecification.infra.persistence.repository.EmployeeRepository;
import com.juliomesquita.jpaspecification.infra.service.interfaces.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findBySearchCriteria(Specification<Employee> spec, Pageable pageable) {
        return employeeRepository.findAll(spec, pageable);
    }
}
