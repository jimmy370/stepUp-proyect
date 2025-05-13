package com.sneakers.store.domain.port;

public interface SendEmailPort {
    void sendEmail(String to, String subject, String body);
}
