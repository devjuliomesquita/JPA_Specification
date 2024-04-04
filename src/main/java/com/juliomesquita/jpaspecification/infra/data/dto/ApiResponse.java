package com.juliomesquita.jpaspecification.infra.data.dto;

import com.juliomesquita.jpaspecification.infra.data.entities.Employee;

import java.util.List;

public record ApiResponse(
        List<Employee> employees,
        Integer page,
        Integer perPage,
        Integer totalPages,
        Long total
) {
    public static Builder builder(){
        return new Builder();
    }
    public static final class Builder{
        private List<Employee> employees;
        private Integer page;
        private Integer perPage;
        private Integer totalPages;
        private Long total;
        private Builder () {}

        public Builder employees(List<Employee> val){
            employees = val;
            return this;
        }
        public Builder page(Integer val){
            page = val;
            return this;
        }

        public Builder perPage(Integer val){
            perPage = val;
            return this;
        }

        public Builder totalPages(Integer val){
            totalPages = val;
            return this;
        }

        public Builder total(Long val){
            total = val;
            return this;
        }

        public ApiResponse build(){
            return new ApiResponse(
                    this.employees,
                    this.page,
                    this.perPage,
                    this.totalPages,
                    this.total
            );

        }
    }
}
