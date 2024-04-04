package com.juliomesquita.jpaspecification.infra.persistence.specification;

import com.juliomesquita.jpaspecification.infra.data.entities.Departament;
import com.juliomesquita.jpaspecification.infra.data.entities.Employee;
import com.juliomesquita.jpaspecification.infra.data.enums.SearchOperation;
import com.juliomesquita.jpaspecification.infra.persistence.criteria.SearchCriteria;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

@RequiredArgsConstructor
public class EmployeeSpecification implements Specification<Employee> {
    private final SearchCriteria searchCriteria;

    @Override
    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        String strToSearch = searchCriteria.getValue().toString().toLowerCase();

        switch (Objects.requireNonNull(
                SearchOperation.getSimpleOperation(
                        searchCriteria.getOperation()
                )
        )) {
            case CONTAINS -> {
                if (searchCriteria.getFilterKey().equals("dept_name")) {
                    return criteriaBuilder.like(criteriaBuilder.lower(this.departamentJoin(root)
                                    .get(searchCriteria.getFilterKey())),
                            "%" + strToSearch + "%");
                }
                return criteriaBuilder.like(
                        criteriaBuilder.lower(
                                root.get(searchCriteria.getFilterKey())
                        ), "%" + strToSearch + "%");
            }
            case DOES_NOT_CONTAIN -> {
                if (searchCriteria.getFilterKey().equals("dept_name")) {
                    return criteriaBuilder.notLike(criteriaBuilder.lower(this.departamentJoin(root)
                            .get(searchCriteria.getFilterKey())
                    ), "%" + strToSearch + "%");
                }
                return criteriaBuilder.notLike(
                        criteriaBuilder.lower(root.get(searchCriteria.getFilterKey())
                        ), "%" + strToSearch + "%");
            }
            case EQUAL -> {
            }
            case NOT_EQUAL -> {
            }
            case BEGINS_WITH -> {
            }
            case DOES_NOT_BEGIN_WITH -> {
            }
            case ENDS_WITH -> {
            }
            case DOES_NOT_END_WITH -> {
            }
            case NULL -> {
            }
            case NOT_NULL -> {
            }
            case GREATER_THAN -> {
            }
            case GREATER_THAN_EQUAL -> {
            }
            case LESS_THAN -> {
            }
            case LESS_THAN_EQUAL -> {
            }
            case ANY -> {
            }
            case ALL -> {
            }
        }

        return null;
    }

    private Join<Employee, Departament> departamentJoin(Root<Employee> root) {
        return root.join("departament");
    }
}
