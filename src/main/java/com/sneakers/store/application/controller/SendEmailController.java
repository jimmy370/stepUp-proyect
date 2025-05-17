package com.sneakers.store.application.controller;

import com.sneakers.store.domain.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store-sneakers/email")
public class SendEmailController {
    @Autowired
    private SendEmailService sendEmailService;

    @GetMapping("/send-mail")
    public void sendEmail() throws Exception {
        sendEmailService.sendReceipt("jimmy70zepeda@gmail.com","PRUEBA SNEAKESRS STORE","Prueba Sneakers stend up");
    }
}
