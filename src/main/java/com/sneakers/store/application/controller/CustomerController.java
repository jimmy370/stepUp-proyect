package com.sneakers.store.application.controller;

import com.sneakers.store.domain.model.Customer;
import com.sneakers.store.domain.service.CustomerService;
import com.sneakers.store.domain.service.PdfService;
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
    public void saveCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
    }

    @GetMapping("/get/customer-by-email")
    public Customer getCustomer(@RequestParam("email") String email){
        return customerService.getCustomer(email);
    }

    @GetMapping("/factura/descargar")
    public ResponseEntity<byte[]> descargarFacturaPdf() throws Exception {
        byte[] pdfBytes = pdfService.generarFacturaPdf("1234", "Juan Pérez", "2025-05-17", "Compra de productos", 150.75);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "factura.pdf"); // Nombre del archivo

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
}
