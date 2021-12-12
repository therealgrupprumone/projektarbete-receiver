package se.iths.projektarbete.receiver;


import se.iths.projektarbete.config.JmsConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import se.iths.projektarbete.dto.EmailNotification;

@Component
public class Receiver {
    @JmsListener(destination = JmsConfig.EMAIL_QUEUE)
    public void listen(@Payload EmailNotification emailNotification) {
        System.out.println("Received: " + emailNotification);
    }

}
