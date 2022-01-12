package se.iths.projektarbete.mail;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class EmailSender {

    private final JavaMailSender mailSender;
    private static final String CSS_STYLE = "<head><style> body {padding: 10px; font-family: Arial, Helvetica, sans-serif;} p {line-height: 1.2; } </style></head>";

    public EmailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String to, String subject, String emailMessage) throws MessagingException {
        MimeMessage htmlEmail = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(htmlEmail);

        helper.setFrom("noreply@chatapp.dev");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(emailMessage, true);

        mailSender.send(htmlEmail);
    }

    public String generateSubject(String username) {
        return "Welcome to ChatApp " + username + "!";
    }

    public String generateEmail(String username) {

        StringBuilder sb = new StringBuilder();

        sb.append("<html>");
            sb.append(CSS_STYLE);
            sb.append("<body>");
            sb.append("<h1> Welcome ").append(username).append("!").append("</h1>");
                sb.append("<p>");
                    sb.append("Here is some info regarding the chat. Please read the info.").append("<br>");
                    sb.append("And here is some more info. Some more. And some more text. Text.").append("<br>");
                    sb.append("<br>");
                    sb.append("Hope you have fun chatting!").append("<br>").append("<br>");
                    sb.append("<i>").append("- From the team at ChatApp").append("</i>");
                  sb.append("</p>");
            sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }
}
