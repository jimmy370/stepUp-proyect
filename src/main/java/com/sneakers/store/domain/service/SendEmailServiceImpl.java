package com.sneakers.store.domain.service;

import com.sneakers.store.domain.port.SendEmailPort;

public class SendEmailServiceImpl implements SendEmailService{
    private SendEmailPort sendEmailPort;

    public SendEmailServiceImpl(SendEmailPort sendEmailPort) {
        this.sendEmailPort = sendEmailPort;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        sendEmailPort.sendEmail(to,subject,body);
    }
}
