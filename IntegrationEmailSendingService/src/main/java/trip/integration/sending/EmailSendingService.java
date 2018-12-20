package trip.integration.sending;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import trip.domain.integration.sending.SendingService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class EmailSendingService implements SendingService {

    private JavaMailSender mailSender;

    public EmailSendingService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void send(String to, String subject, String content) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);

            mailSender.send(message);
        } catch (MessagingException ex) {
            throw new RuntimeException("Failed to send email", ex);
        }
    }
}
