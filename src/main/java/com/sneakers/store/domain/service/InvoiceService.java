package com.sneakers.store.domain.service;

import com.sneakers.store.domain.model.Invoice;
import com.sneakers.store.domain.model.Order;

public interface InvoiceService {

    void saveInvoice(Order order);
}
