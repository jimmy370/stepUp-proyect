package com.sneakers.store.infraestructure.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StoreLinksEntity {
    private String stockX;
    private String goat;
    private String flightClub;
    private String stadiumGoods;
}
