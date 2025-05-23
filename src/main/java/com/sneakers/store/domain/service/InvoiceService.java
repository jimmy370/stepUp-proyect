package com.sneakers.store.domain.service;

import com.sneakers.store.domain.model.Customer;
import com.sneakers.store.domain.model.DetailsOrder;
import com.sneakers.store.domain.model.Invoice;
import com.sneakers.store.domain.model.Order;

import java.util.List;

public interface InvoiceService {

    void saveInvoice(Order order, List<DetailsOrder> detailsOrders, Customer customer) throws Exception;

}
