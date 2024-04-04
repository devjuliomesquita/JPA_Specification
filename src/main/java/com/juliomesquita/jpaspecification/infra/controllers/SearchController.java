package com.juliomesquita.jpaspecification.infra.controllers;

import com.juliomesquita.jpaspecification.infra.data.dto.ApiResponse;
import com.juliomesquita.jpaspecification.infra.data.dto.EmployeeSearchDto;
import com.juliomesquita.jpaspecification.infra.data.entities.Employee;
import com.juliomesquita.jpaspecification.infra.persistence.criteria.SearchCriteria;
import com.juliomesquita.jpaspecification.infra.persistence.specification.EmployeeSpecificationBuilder;
import com.juliomesquita.jpaspecification.infra.service.interfaces.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class SearchController {
    private final EmployeeService employeeService;

    @PostMapping(value = "/search")
    public ResponseEntity<ApiResponse> searchEmployees(
            @RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestBody EmployeeSearchDto employeeSearchDto
            ){
        EmployeeSpecificationBuilder builder = new EmployeeSpecificationBuilder();

        List<SearchCriteria> searchCriteriaList = employeeSearchDto.getSearchCriteriaList();
        if(searchCriteriaList != null){
            searchCriteriaList.forEach(
                    searchCriteria -> {
                        searchCriteria.setDataOption(employeeSearchDto.getDataOption());
                        builder.params(searchCriteria);
                    }
            );
        }
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize);
        Page<Employee> employeePage = this.employeeService.findBySearchCriteria(builder.build(), pageRequest);
        ApiResponse response = ApiResponse
                .builder()
                .employees(employeePage.getContent())
                .page(employeePage.getNumber())
                .perPage(employeePage.getSize())
                .totalPages(employeePage.getTotalPages())
                .total(employeePage.getTotalElements())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
