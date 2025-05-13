package com.sneakers.store.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RequestCriteria {
    private String limit;
    private List<Criteria> criteria;
}
