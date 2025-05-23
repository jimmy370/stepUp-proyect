package com.sneakers.store.domain.port;

import jakarta.mail.MessagingException;

public interface SendEmailPort {
    void sendEmail(String to, String subject, String body) throws MessagingException;

    void sendReceipt(String to, String subject, String body, byte[] archivoAdjunto, String nombreArchivo) throws Exception;
}
