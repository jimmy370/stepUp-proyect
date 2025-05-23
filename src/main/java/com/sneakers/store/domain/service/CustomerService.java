package com.sneakers.store.domain.service;

import com.sneakers.store.domain.dto.CustomerDto;
import com.sneakers.store.domain.model.Customer;
import jakarta.mail.MessagingException;

public interface CustomerService {

    void saveCustomer(Customer customer) throws MessagingException;

    CustomerDto getCustomer(String emailCustomer);

    boolean verifyLogin(String email, String password);

    boolean verifyCodeConfirmation(String email,String codeConfirmation);


}
