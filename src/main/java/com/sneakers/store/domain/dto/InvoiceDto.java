package com.sneakers.store.domain.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class InvoiceDto {
    private String invoiceNumber;
    private BigDecimal total;
    private LocalDateTime issueDate;
}
