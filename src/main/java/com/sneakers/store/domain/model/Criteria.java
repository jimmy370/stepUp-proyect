package com.sneakers.store.domain.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Criteria {
    private String nameField;
    private String value;
}
