package com.sneakers.store.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class InvoiceRequestdos {
    private String invoiceNo;
    private String issueDate;
    private String dueDate;
    private String clientName;
    private String clientCompany;
    private String clientAddress;
    private List<ProductItem> products;
    private int taxPercent;
    private String accountName;
    private String accountNo;
}
