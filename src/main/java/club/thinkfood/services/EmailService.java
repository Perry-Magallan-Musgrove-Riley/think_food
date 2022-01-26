package club.thinkfood.services;

import club.thinkfood.models.Recipe;
import club.thinkfood.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Value("${spring.mail.from}")
    private String from;

    public void prepareAndSend(Recipe chef, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
//         need a new instance to reference User
        msg.setTo(chef.getUser().getEmail());
        msg.setSubject(subject);
        msg.setText(body);

        try{
            this.emailSender.send(msg);
        }
        catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
    }

    public void prepareAndSend(User chef, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
//         need a new instance to reference User
        msg.setTo(chef.getEmail());
        msg.setSubject(subject);
        msg.setText(body);

        try{
            this.emailSender.send(msg);
        }
        catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
    }
}



