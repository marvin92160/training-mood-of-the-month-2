package services.MailingService;

import jakarta.annotation.Resource;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import modele.Email;

public class EmailService {

    @Resource(name = "java:jboss/mail/Default")
    private Session session;

    public void sendEmail(Email email) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getMemberEmail()));
        message.setSubject(email.getSubject());
        message.setText(email.getTemplate());

        Transport.send(message);
    }
}
