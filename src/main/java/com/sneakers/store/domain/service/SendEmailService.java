package com.sneakers.store.domain.service;

public interface SendEmailService {
    void sendEmail(String to, String subject, String body);

    void sendReceipt(String to, String subject, String body) throws Exception;
}
