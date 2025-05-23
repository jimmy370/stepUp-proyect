package com.sneakers.store.domain.dto;

import com.sneakers.store.domain.model.Customer;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class OrderDto {
    private String orderCode;
    private LocalDateTime date;
    private List<DetailsDto> details;
    private InvoiceDto invoice;
}
