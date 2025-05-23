package com.sneakers.store.domain.service;

import com.sneakers.store.domain.model.DetailsOrder;
import com.sneakers.store.domain.model.Order;
import com.sneakers.store.domain.port.CustomerPort;
import com.sneakers.store.domain.port.OrderDetailsPort;
import com.sneakers.store.domain.port.OrderPort;
import com.sneakers.store.infraestructure.mapper.CustomerMapper;
import com.sneakers.store.infraestructure.mapper.OrderMapper;
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

    private OrderDetailsPort orderDetailsPort;

    private OrderMapper orderMapper;
    @Override
    public void saveOrder(String email, List<DetailsOrder> detailsOrders ) throws Exception {
        var customer = customerPort.getCustomer(email);
            Order order = Order
                    .builder()
                    .orderCode("OR-" + UUID.randomUUID().toString().substring(0, 8))
                    .date(LocalDateTime.now())
                    .customer(customer)
                    .build();
                var orderSave  = orderPort.saveOrder(order);
                buildDetailsOrder(orderSave, detailsOrders);
            invoiceService.saveInvoice(orderSave, detailsOrders,customer);
    }

    private void buildDetailsOrder (Order order, List<DetailsOrder> detailsOrders){
        for (DetailsOrder detailsOrder : detailsOrders) {
            DetailsOrder details = DetailsOrder
                    .builder()
                    .order(order)
                    .price(detailsOrder.getPrice())
                    .amount(detailsOrder.getAmount())
                    .productCode(detailsOrder.getProductCode())
                    .build();
            orderDetailsPort.saveOrderDetails(details);
        }
    }

}
