package com.sneakers.store.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SneakersResponse {
    private int count;
    private int totalPages;
    private List<Sneakers> results;

}
