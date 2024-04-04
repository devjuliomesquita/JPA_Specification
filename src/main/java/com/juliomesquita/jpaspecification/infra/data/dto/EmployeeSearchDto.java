package com.juliomesquita.jpaspecification.infra.data.dto;

import com.juliomesquita.jpaspecification.infra.persistence.criteria.SearchCriteria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSearchDto {
    private List<SearchCriteria> searchCriteriaList;
    private String dataOption;
}
