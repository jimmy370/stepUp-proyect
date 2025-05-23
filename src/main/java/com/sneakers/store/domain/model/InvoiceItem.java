package com.sneakers.store.domain.model;

import lombok.Data;

@Data
public class InvoiceItem {
    private String description;
    private double unitPrice;
    private int quantity;
}