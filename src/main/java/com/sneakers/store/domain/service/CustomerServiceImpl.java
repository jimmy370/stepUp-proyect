package com.sneakers.store.domain.service;

import com.sneakers.store.domain.model.Customer;
import com.sneakers.store.domain.port.CustomerPort;
import com.sneakers.store.domain.port.SendEmailPort;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private CustomerPort customerPort;

    private SendEmailPort sendEmailPort;

    private static String PREFIX_CODE_CONFIRMATION ="STP";

    private static final Random RANDOM = new Random();
    @Override
    public void saveCustomer(Customer customer) {
        customer.setRegistrationDate(LocalDateTime.now());
        customerPort.saveCustomer(customer);
        sendEmailPort.sendEmail(customer.getEmail(),"Confirmacion de correo STENDUP","su codigo de confirmacion es : "+ generateCode(PREFIX_CODE_CONFIRMATION));
    }

    @Override
    public Customer getCustomer(String emailCustomer) {
        return customerPort.getCustomer(emailCustomer);
    }

    private static String generateCode(String prefixCode) {
        for (int i =0; i<=1; i++) {
            int number = RANDOM.nextInt(100) + 1;
            prefixCode = prefixCode + number;
        }
        return prefixCode ;
    }
}
