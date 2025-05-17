package com.sneakers.store.infraestructure.adapter;

import com.sneakers.store.domain.port.SendEmailPort;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SendEmailAdapter implements SendEmailPort {
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("jimmyzepeda167@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }

    @Override
    public void sendReceipt(String to, String subject, String body, byte[] archivoAdjunto, String nombreArchivo) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();

        // true = multipart (permite adjuntos)
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, false); // false = texto plano

        // Adjuntar el PDF
        helper.addAttachment(nombreArchivo, new ByteArrayResource(archivoAdjunto));

        mailSender.send(message);
    }
}
