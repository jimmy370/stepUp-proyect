package com.sneakers.store.application.controller;

import com.sneakers.store.domain.dto.CustomerDto;
import com.sneakers.store.domain.model.Customer;
import com.sneakers.store.domain.model.InvoiceRequest;
import com.sneakers.store.domain.model.InvoiceRequestdos;
import com.sneakers.store.domain.service.CustomerService;
import com.sneakers.store.domain.service.PdfService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PdfService pdfService;

    @PostMapping
    public void saveCustomer(@RequestBody Customer customer) throws MessagingException {
        customerService.saveCustomer(customer);
    }

    @GetMapping("/get/customer-by-email")
    public ResponseEntity<CustomerDto> getCustomer(@RequestParam("email") String email){
        return ResponseEntity.ok(customerService.getCustomer(email));
    }
    @GetMapping("/get/verify/login")
    public ResponseEntity<Boolean> verifyLogin(@RequestParam("email") String email,@RequestParam("password") String password){
        return ResponseEntity.ok(customerService.verifyLogin(email,password));
    }
    @GetMapping("/get/verify/email")
    public ResponseEntity<Boolean> verifyEmail(@RequestParam("email") String email,@RequestParam("code") String code){
        return ResponseEntity.ok(customerService.verifyCodeConfirmation(email,code));
    }


}
