package com.sneakers.store.domain.service;

import com.sneakers.store.domain.model.DetailsOrder;
import com.sneakers.store.domain.model.Order;

import java.util.List;

public interface OrderService {

    void saveOrder(String email, List<DetailsOrder> detailsOrders ) throws Exception;
}
