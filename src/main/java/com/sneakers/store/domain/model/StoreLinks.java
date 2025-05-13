package com.sneakers.store.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreLinks {
    private String stockX;
    private String goat;
    private String flightClub;
    private String stadiumGoods;
}
