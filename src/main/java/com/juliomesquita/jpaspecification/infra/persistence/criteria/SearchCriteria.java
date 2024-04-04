package com.juliomesquita.jpaspecification.infra.persistence.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria {

    private String filterKey;
    private Object value;
    private String operation;
    private String dataOption;

    public SearchCriteria(String filterKey, Object value, String operation) {
//        super();
        this.filterKey = filterKey;
        this.value = value;
        this.operation = operation;
    }
}
