package com.example.marocship.helpers;

import io.github.cdimascio.dotenv.Dotenv;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class SendMail {

    public static void sendDeliveryInfos(String userEmail, String msg) {
        Dotenv dotEnv = Dotenv.configure().load();
        // Sender's email ID needs to be mentioned
        String email = dotEnv.get("EMAIL_ADDRESS");
        String password = dotEnv.get("EMAIL_PASSWORD");

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(email, password);

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            assert email != null;
            message.setFrom(new InternetAddress(email));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));

            // Set Subject: header field
            message.setSubject("Marjane Service: Account information");

            // Now set the actual message
            message.setText(msg);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
