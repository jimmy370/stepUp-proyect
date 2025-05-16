package com.sneakers.store.domain.service;

import com.sneakers.store.domain.model.Customer;

public interface CustomerService {

    void saveCustomer(Customer customer);

    Customer getCustomer(String emailCustomer);


}
