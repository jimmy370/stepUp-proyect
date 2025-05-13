package com.sneakers.store.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BrandsAndGendersResponse {
    private List<String>results;
}
