package com.sneakers.store.infraestructure.adapter;

import com.sneakers.store.domain.port.SendEmailPort;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class SendEmailAdapter implements SendEmailPort {
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String to, String subject, String body) throws MessagingException {
        String html = """
                   <!DOCTYPE html>
                   <html>
                     <body style="margin: 0; padding: 0; background-color: #f2f2f2;">
                       <table align="center" cellpadding="0" cellspacing="0" width="100%%" style="padding: 40px 0;">
                         <tr>
                           <td align="center">
                             <table width="600" cellpadding="0" cellspacing="0" style="background-color: #ffffff; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1); font-family: Arial, sans-serif;">
                               <tr>
                                 <td style="background-color: #000000; color: #ffffff; padding: 20px; border-top-left-radius: 10px; border-top-right-radius: 10px; text-align: center;">
                                   <h1 style="margin: 0;">STEP-UP</h1>
                                   <p style="margin: 5px 0 0; font-size: 16px;">Tu tienda de zapatillas favorita</p>
                                 </td>
                               </tr>
                               <tr>
                                 <td style="padding: 30px; text-align: center;">
                                   <h2 style="color: #333333;">¡Aquí está tu código de confirmación!</h2>
                                   <p style="font-size: 16px; color: #666666;">Estamos verificando tu identidad para proteger tu cuenta.</p>
                                   <div style="margin: 30px auto; display: inline-block; background-color: #ff4d4d; color: #ffffff; font-size: 28px; padding: 15px 30px; border-radius: 8px; letter-spacing: 4px; font-weight: bold;">
                                     {{CODIGO}}
                                   </div>
                                   <p style="font-size: 14px; color: #888888; margin-top: 30px;">Si no solicitaste este código, puedes ignorar este mensaje.</p>
                                 </td>
                               </tr>
                               <tr>
                                 <td style="background-color: #fafafa; text-align: center; padding: 20px; border-bottom-left-radius: 10px; border-bottom-right-radius: 10px; color: #999999; font-size: 13px;">
                                   © 2025 STEP-UP. Todos los derechos reservados.
                                 </td>
                               </tr>
                             </table>
                           </td>
                         </tr>
                       </table>
                     </body>
                   </html>
                """.replace("{{CODIGO}}",body);
        MimeMessage message1 = mailSender.createMimeMessage();
        MimeMessageHelper message= new MimeMessageHelper(message1, true);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(html,true);

        mailSender.send(message1);
    }

    @Override
    public void sendReceipt(String to, String subject, String body, byte[] archivoAdjunto, String nombreArchivo) throws Exception {
        body = """
                <!DOCTYPE html>
                <html>
                <head>
                  <meta charset="UTF-8">
                  <style>
                    body {
                      margin: 0;
                      padding: 0;
                      background-color: #f2f2f2;
                      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                    }
                    .container {
                      max-width: 600px;
                      margin: 40px auto;
                      background-color: #ffffff;
                      border-radius: 8px;
                      overflow: hidden;
                      box-shadow: 0 4px 12px rgba(0,0,0,0.1);
                    }
                    .header {
                      background-color: #111111;
                      color: #ffffff;
                      padding: 20px;
                      text-align: center;
                    }
                    .header img {
                      max-height: 50px;
                      margin-bottom: 10px;
                    }
                    .header h1 {
                      margin: 0;
                      font-size: 24px;
                      text-transform: uppercase;
                      letter-spacing: 1px;
                    }
                    .content {
                      padding: 30px;
                      color: #333333;
                    }
                    .content h2 {
                      color: #111111;
                    }
                    .content p {
                      line-height: 1.6;
                    }
                    .cta-button {
                      display: inline-block;
                      margin-top: 20px;
                      padding: 12px 24px;
                      background-color: #ff3c38;
                      color: white;
                      text-decoration: none;
                      border-radius: 5px;
                      font-weight: bold;
                    }
                    .footer {
                      background-color: #f7f7f7;
                      text-align: center;
                      padding: 15px;
                      font-size: 13px;
                      color: #888888;
                    }
                  </style>
                </head>
                <body>
                  <div class="container">
                    <div class="header">
                      <h1>Step-Up</h1>
                    </div>
                    <div class="content">
                      <h2>¡Gracias por tu compra, ${nombreCliente}!</h2>
                      <p>
                        Hemos recibido tu pedido <strong>#${numeroPedido}</strong> y adjuntamos la factura en formato PDF a este correo.
                      </p>
                      <p>
                        Estamos procesando tu pedido para que pronto puedas disfrutar de tus nuevas zapatillas.
                      </p>
                      <a class="cta-button" href="https://effervescent-medovik-42928f.netlify.app/">Explora más estilos</a>
                    </div>
                    <div class="footer">
                      © 2025 Step-up — Todos los derechos reservados<br/>
                      Este correo fue enviado automáticamente, por favor no respondas.
                    </div>
                  </div>
                </body>
                </html>
                              
                """;
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true);
        helper.addAttachment(nombreArchivo, new ByteArrayResource(archivoAdjunto), "application/pdf");
        mailSender.send(message);
    }
}
