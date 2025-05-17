package com.sneakers.store.domain.model;

import com.sneakers.store.infraestructure.entity.CustomerEntity;
import com.sneakers.store.infraestructure.entity.InvoiceEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Order {

    private Long id;

    private String orderId;

    private String idProduct;

    private LocalDateTime date;

    private CustomerEntity customer;

    private InvoiceEntity invoice;

}
