package com.sneakers.store.domain.service;

import com.sneakers.store.domain.dto.CustomerDto;
import com.sneakers.store.domain.model.Customer;
import com.sneakers.store.domain.port.CustomerPort;
import com.sneakers.store.domain.port.SendEmailPort;
import com.sneakers.store.infraestructure.mapper.CustomerMapper;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Random;

@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private CustomerPort customerPort;

    private SendEmailPort sendEmailPort;

    private CustomerMapper customerMapper;

    private static String PREFIX_CODE_CONFIRMATION ="STP";

    private static String SUBJECT_EMAIL ="Confirmacion de correo STEPUP";

    private PasswordEncoder passwordEncoder;
    private static final Random RANDOM = new Random();
    @Override
    public void saveCustomer(Customer customer) throws MessagingException {
        var codeConfirmation = generateCode(PREFIX_CODE_CONFIRMATION);
        customer.setRegistrationDate(LocalDateTime.now());
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setCodeConfirmation(codeConfirmation);
        customerPort.saveCustomer(customer);
        sendEmailPort.sendEmail(customer.getEmail(),SUBJECT_EMAIL,codeConfirmation);
    }

    @Override
    public CustomerDto getCustomer(String emailCustomer) {
        return customerMapper.fromCustomer(customerPort.getCustomer(emailCustomer));
    }

    @Override
    public boolean verifyLogin(String email, String password) {
        var user = customerMapper.fromCustomer(customerPort.getCustomer(email));
        return passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    public boolean verifyCodeConfirmation(String email, String codeConfirmation) {
        var customer = customerMapper.fromCustomer(customerPort.getCustomer(email));;
        return customer.getCodeConfirmation().equalsIgnoreCase(codeConfirmation) ;
    }

    private static String generateCode(String prefixCode) {
        for (int i =0; i<=1; i++) {
            int number = RANDOM.nextInt(100) + 1;
            prefixCode = prefixCode + number;
        }
        return prefixCode ;
    }
}
