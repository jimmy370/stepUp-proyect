package com.sneakers.store.domain.service;

import com.sneakers.store.domain.model.*;
import com.sneakers.store.domain.port.InvoicePort;
import com.sneakers.store.domain.port.SendEmailPort;
import com.sneakers.store.infraestructure.mapper.OrderMapper;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
public class InvoiceServiceImpl implements InvoiceService{

    private InvoicePort invoicePort;

    private OrderMapper orderMapper;

    private PdfService pdfService;

    private SendEmailPort sendEmailPort;

    private static String SUBJECT_EMAIL_INVOICE ="Gracias por su compra aqui adjuntamos su factura";

    private static String FILE_NAME = "factura.pdf";
    @Override
    public void saveInvoice(Order order, List<DetailsOrder> detailsOrders, Customer customer) throws Exception {
        int total = 0;
        for (DetailsOrder detailsOrder: detailsOrders){
            total = (int) (total +detailsOrder.getPrice());
        }
        Invoice invoice = Invoice
                .builder()
                .invoiceNumber("F-" + UUID.randomUUID().toString().substring(0, 8))
                .issueDate(LocalDateTime.now())
                .order(order)
                .total(new BigDecimal(total))
                .build();
        invoicePort.saveInvoice(invoice);
         var invoiceResult = pdfService.generateInvoice(invoice.getInvoiceNumber(),invoice.getIssueDate().toLocalDate().toString(),customer.getName(), customer.getAddress(),buildProduct(detailsOrders));
         sendEmailPort.sendReceipt(customer.getEmail(), SUBJECT_EMAIL_INVOICE,"factura",invoiceResult,FILE_NAME);
    }

    private List<ProductItem> buildProduct(List<DetailsOrder> detailsOrders){
        List<ProductItem> orderList = new ArrayList<>();
        for (DetailsOrder detailsOrder: detailsOrders){
            ProductItem productItem = ProductItem
                    .builder()
                    .description(detailsOrder.getDescription())
                    .quantity(detailsOrder.getAmount())
                    .unitPrice(new BigDecimal(detailsOrder.getPrice()))
                    .build();
            orderList.add(productItem);
        }
        return orderList;
    }
}
