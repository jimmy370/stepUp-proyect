package com.sneakers.store.domain.model;

import com.sneakers.store.infraestructure.entity.OrderEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetailsOrder {
    private Long id;

    private Integer amount;

    private Double price;

    private Order order;

    private String productCode;

    private String description;

}
