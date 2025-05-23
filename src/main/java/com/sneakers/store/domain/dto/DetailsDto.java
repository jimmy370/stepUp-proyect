package com.sneakers.store.domain.dto;

import com.sneakers.store.domain.model.Order;
import lombok.Data;

@Data
public class DetailsDto {
    private String productCode;
    private Integer amount;
    private Double price;
}
