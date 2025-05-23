package com.sneakers.store.domain.service;

import com.sneakers.store.domain.model.InvoiceRequest;
import com.sneakers.store.domain.model.ProductItem;

import java.io.OutputStream;
import java.util.List;

public interface PdfService {
    byte[] generateInvoice(String invoiceNo, String issueDate, String clientName, String clientAddress,
                           List<ProductItem> products) throws Exception;
}
