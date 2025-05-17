package com.sneakers.store.domain.port;

import com.sneakers.store.domain.model.Customer;
import com.sneakers.store.domain.model.Order;

public interface OrderPort {

    Order saveOrder(Order order);
}
