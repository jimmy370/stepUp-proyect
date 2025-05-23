package com.sneakers.store.infraestructure.adapter;

import com.sneakers.store.domain.dto.CustomerDto;
import com.sneakers.store.domain.model.Customer;
import com.sneakers.store.domain.port.CustomerPort;
import com.sneakers.store.infraestructure.mapper.CustomerMapper;
import com.sneakers.store.infraestructure.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerAdapter implements CustomerPort {
    private CustomerRepository customerRepository;

    private CustomerMapper customerMapper;

    public CustomerAdapter(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public void saveCustomer(Customer customer) {
     customerRepository.save(customerMapper.toCustomerEntity(customer));
    }

    @Override
    public Customer getCustomer(String emailCustomer) {
        var customerEntity = customerRepository.getCustomerByEmail(emailCustomer);
        return customerEntity.map(customer -> customerMapper.toCustomer(customer)).orElse(null);
    }
}
