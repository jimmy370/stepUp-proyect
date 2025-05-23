package com.sneakers.store.domain.model;

import com.sneakers.store.infraestructure.entity.OrderEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Builder
public class Invoice {
    private Long id;

    private String invoiceNumber;

    private LocalDateTime issueDate;

    private BigDecimal total;

    private Order order;
}
