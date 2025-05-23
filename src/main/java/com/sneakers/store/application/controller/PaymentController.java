package com.sneakers.store.application.controller;

import com.sneakers.store.domain.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/pay/sneakers")
    public Map<String, String> payProduct(@RequestBody Map<String, Object> paymentData) throws Exception{
        return paymentService.paySneakers(paymentData);
    }
}
