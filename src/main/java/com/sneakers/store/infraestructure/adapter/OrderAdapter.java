package com.sneakers.store.infraestructure.adapter;

import com.sneakers.store.domain.model.Customer;
import com.sneakers.store.domain.model.Order;
import com.sneakers.store.domain.port.OrderPort;
import com.sneakers.store.infraestructure.mapper.OrderMapper;
import com.sneakers.store.infraestructure.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderAdapter implements OrderPort {

    private OrderRepository orderRepository;

    private OrderMapper orderMapper;


    public OrderAdapter(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(orderMapper.toOrderEntity(order));
    }
}
