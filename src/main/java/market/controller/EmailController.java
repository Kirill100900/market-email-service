package market.controller;

import freemarker.template.TemplateException;
import market.dto.MailMessageDto;
import market.model.MailLanguages;
import market.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
public class EmailController {

    private static final Logger LOG = LoggerFactory.getLogger(EmailController.class);

    private final MailService mailService;

    public EmailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping(value = "/email/{user-email}")
    public Mono<ResponseEntity> sendSimpleEmail(@PathVariable("user-email") String email) {
        MailMessageDto mailMessageDto = new MailMessageDto("", email, "", MailLanguages.RU);
        return Mono.fromRunnable(() -> {
                    try {
                        mailService.sendMessageUsingFreemarkerTemplate(mailMessageDto);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                })
                .map(ResponseEntity::ok);
    }

}



