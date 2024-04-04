package com.juliomesquita.jpaspecification.infra.persistence.specification;

import com.juliomesquita.jpaspecification.infra.data.entities.Employee;
import com.juliomesquita.jpaspecification.infra.data.enums.SearchOperation;
import com.juliomesquita.jpaspecification.infra.persistence.criteria.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSpecificationBuilder {
    private final List<SearchCriteria> params;

    public EmployeeSpecificationBuilder() {
        this.params = new ArrayList<>();
    }

    public final EmployeeSpecificationBuilder params(
            String key,
            Object value,
            String operation
    ) {
        params.add(new SearchCriteria(key, value, operation));
        return this;
    }

    public final EmployeeSpecificationBuilder params(SearchCriteria val) {
        params.add(val);
        return this;
    }

    public Specification<Employee> build() {
        if (params.isEmpty()) {
            return null;
        }

        Specification<Employee> result = new EmployeeSpecification(params.get(0));
        for (int i = 1; i < params.size(); i++) {
            SearchCriteria criteria = params.get(i);
            result = SearchOperation.getDataOption(criteria.getDataOption()) == SearchOperation.ALL
                    ? Specification.where(result).and(new EmployeeSpecification(criteria))
                    : Specification.where(result).or(new EmployeeSpecification(criteria));
        }
        return result;
    }
}
