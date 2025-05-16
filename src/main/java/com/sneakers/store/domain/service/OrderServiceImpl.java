package com.sneakers.store.domain.service;

import com.sneakers.store.domain.model.Order;
import com.sneakers.store.domain.port.CustomerPort;
import com.sneakers.store.domain.port.OrderPort;
import com.sneakers.store.infraestructure.mapper.CustomerMapper;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class OrderServiceImpl implements OrderService{

    private OrderPort orderPort;

    private CustomerPort customerPort;

    private CustomerMapper customerMapper;

    private InvoiceService invoiceService;
    @Override
    public void saveOrder(String email, List<String> idProducts) {
        var customer = customerPort.getCustomer(email);
        for (String idProduct : idProducts){
            Order order = Order
                    .builder()
                    .orderId("OR-" + UUID.randomUUID().toString().substring(0, 8))
                    .date(LocalDateTime.now())
                    .customer(customerMapper.toCustomerEntity(customer))
                    .idProduct(idProduct)
                    .build();
            orderPort.saveOrder(order);
            invoiceService.saveInvoice(order);
        }
    }

}
