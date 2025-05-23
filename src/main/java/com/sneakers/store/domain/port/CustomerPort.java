package com.sneakers.store.domain.port;

import com.sneakers.store.domain.dto.CustomerDto;
import com.sneakers.store.domain.model.Customer;
import com.sneakers.store.infraestructure.entity.CustomerEntity;
import org.mapstruct.Mapping;

public interface CustomerPort {
    void saveCustomer(Customer customer);

    Customer getCustomer(String emailCustomer);

}
