package com.sneakers.store.domain.service;

import jakarta.mail.MessagingException;

public interface SendEmailService {
    void sendEmail(String to, String subject, String body) throws MessagingException;

    void sendReceipt(String to, String subject, String body) throws Exception;
}
