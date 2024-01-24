package com.master.trainingcentermanagement.service.impl;

import com.master.trainingcentermanagement.service.MailSenderService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;

import org.thymeleaf.context.Context;

@RequiredArgsConstructor
@Service
    public class MailSenderServiceImp {
        private final JavaMailSender mailSender;
        private final TemplateEngine templateEngine;

//    @Override
//        public String sendNewMail(String to, String subject, String body) {
//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setTo(to);
//            message.setSubject(subject);
//            message.setText(body);
//            mailSender.send(message);
//            return "the email has sent successfully!";
//        }

    public void sendEmailWithHtmlTemplate(String to, String subject, String templateName, Context context) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");

        try {
            helper.setTo(to);
            helper.setSubject(subject);
            String htmlContent = templateEngine.process(templateName,  context);
            helper.setText(htmlContent, true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            // Handle exception
        }
    }

}
