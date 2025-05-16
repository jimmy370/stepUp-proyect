package com.sneakers.store.domain.service;

import com.sneakers.store.domain.model.Invoice;
import com.sneakers.store.domain.model.Order;
import com.sneakers.store.domain.port.InvoicePort;
import com.sneakers.store.infraestructure.mapper.OrderMapper;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;
@AllArgsConstructor
public class InvoiceServiceImpl implements InvoiceService{

    private InvoicePort invoicePort;

    private OrderMapper orderMapper;
    @Override
    public void saveInvoice(Order order) {
        Invoice invoice = Invoice
                .builder()
                .invoiceNumber("F-" + UUID.randomUUID().toString().substring(0, 8))
                .issueDate(LocalDateTime.now())
                .order(orderMapper.toOrderEntity(order))
                .build();
        invoicePort.saveInvoice(invoice);
    }
}
