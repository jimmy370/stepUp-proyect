package com.sneakers.store.domain.service;

import com.sneakers.store.domain.port.SendEmailPort;

import java.nio.charset.StandardCharsets;

public class SendEmailServiceImpl implements SendEmailService{
    private SendEmailPort sendEmailPort;

    public SendEmailServiceImpl(SendEmailPort sendEmailPort) {
        this.sendEmailPort = sendEmailPort;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        sendEmailPort.sendEmail(to,subject,body);
    }

    @Override
    public void sendReceipt(String to, String subject, String body) throws Exception {
        sendEmailPort.sendReceipt(to,subject,body,"pdf".getBytes(StandardCharsets.UTF_8), "factura1");
    }
}
