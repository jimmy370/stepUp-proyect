package com.sneakers.store.application.controller;

import com.sneakers.store.domain.model.Customer;
import com.sneakers.store.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public void saveCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
    }

    @GetMapping("/get/customer-by-email")
    public Customer getCustomer(@RequestParam("email") String email){
        return customerService.getCustomer(email);
    }
}
