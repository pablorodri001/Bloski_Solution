package UtilidadesEntidades;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;

public class Mail {

    private String fromEmail;
    private String password;

    public Mail(String fromEmail, String password) {
        this.fromEmail = fromEmail;
        this.password = password;
    }

    public void sendEmail(String toEmail, String subject, String body, String attachmentPath) throws MessagingException, IOException {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            if (attachmentPath != null) {
                MimeBodyPart attachmentBodyPart = new MimeBodyPart();
                attachmentBodyPart.attachFile(attachmentPath);
                multipart.addBodyPart(attachmentBodyPart);
            }

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Correo electrónico enviado con éxito a " + toEmail);
        } catch (MessagingException | IOException e) {
            System.err.println("Error al enviar el correo electrónico: " + e.getMessage());
            throw e;
        }
    }
}
