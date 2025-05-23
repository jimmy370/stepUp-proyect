package com.sneakers.store.domain.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductItem {
    private String description;
    private BigDecimal unitPrice;
    private int quantity;

}
