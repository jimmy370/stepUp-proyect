package com.sneakers.store.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class InvoiceRequest {
    private String customerName;
    private String company;
    private String address;
    private String invoiceNumber;
    private String date;
    private String dueDate;
    private List<InvoiceItem> items;
}