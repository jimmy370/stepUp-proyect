package com.sneakers.store.domain.port;

import com.sneakers.store.domain.model.Customer;

public interface CustomerPort {
    void saveCustomer(Customer customer);

    Customer getCustomer(String emailCustomer);
}
