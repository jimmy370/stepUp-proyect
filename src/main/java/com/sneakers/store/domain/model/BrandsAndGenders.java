package com.sneakers.store.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BrandsAndGenders {
    private List<String> brands;
    private List<String> genders;
}
