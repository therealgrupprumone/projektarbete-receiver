package se.iths.projektarbete.receiver;


import se.iths.projektarbete.config.JmsConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import se.iths.projektarbete.dto.EmailNotification;
import se.iths.projektarbete.mail.EmailSender;

import javax.mail.MessagingException;

@Component
public class Receiver {

    private EmailSender emailSender;

    public Receiver(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @JmsListener(destination = JmsConfig.EMAIL_QUEUE)
    public void listen(@Payload EmailNotification emailNotification) {

        System.out.println("Trying to send email to user: " + emailNotification.getUsername());

        String subject = emailSender.generateSubject(emailNotification.getUsername());
        String emailMessage = emailSender.generateEmail(emailNotification.getUsername());

        try {
            emailSender.sendEmail("emailOfUser@email.com", subject, emailMessage);
        } catch (MessagingException e) {
            System.out.println("Failed to send email.");
            e.printStackTrace();
        }
    }


}
