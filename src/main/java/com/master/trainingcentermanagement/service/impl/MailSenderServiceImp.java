package com.master.trainingcentermanagement.service.impl;

import com.master.trainingcentermanagement.service.MailSenderService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import org.thymeleaf.context.Context;

@RequiredArgsConstructor
@Service
    public class MailSenderServiceImp implements MailSenderService{
        private final JavaMailSender mailSender;
        private final TemplateEngine templateEngine;

    @Override
    public void sendEmailWithHtmlTemplate(String to, String subject, String templateName, Context context, Long courseId) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");

        try {
            helper.setTo(to);
            helper.setSubject(subject);
            context.setVariable("courseId", courseId);
            String htmlContent = templateEngine.process(templateName,  context);
            helper.setText(htmlContent, true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            // Handle exception
        }
    }

}
