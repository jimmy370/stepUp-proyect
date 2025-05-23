package com.sneakers.store.domain.model;

import com.sneakers.store.infraestructure.entity.CustomerEntity;
import com.sneakers.store.infraestructure.entity.DetailsOrderEntity;
import com.sneakers.store.infraestructure.entity.InvoiceEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Order {

    private Long id;

    private String orderCode;

    private LocalDateTime date;

    private Customer customer;

    private Invoice invoice;

    private List<DetailsOrder> details;

}
