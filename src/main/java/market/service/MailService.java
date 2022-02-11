package market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String mailMarket;

//    public void sender(String emailTo,String subject, String text) { //простое письмо
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setFrom(mailMarket);
//        msg.setTo(emailTo);
//        msg.setSubject(subject);
//        msg.setText(text);
//        javaMailSender.send(msg);
//    }
    public void sender(String emailto, String subject, String htmlBody) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setTo(emailto);
        helper.setSubject(subject);
        helper.setText(htmlBody, true);
        javaMailSender.send(message);
        System.out.println("message sent");
    }
}

