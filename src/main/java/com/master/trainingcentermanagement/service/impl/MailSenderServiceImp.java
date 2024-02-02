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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;

@RequiredArgsConstructor
@Service
    public class MailSenderServiceImp implements MailSenderService{
        private final JavaMailSender mailSender;
        private final TemplateEngine templateEngine;

    public void sendEmailWithHtmlTemplate(String to, String subject, String templateName, Context context, Long courseId, Long participantId) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");

        try {
            // Encode parameters using Base64
            String params = "courseId=" + courseId + "&participantId=" + participantId;
            String encodedParams = Base64.getEncoder().encodeToString(params.getBytes("UTF-8"));

            // Include encoded params in the URL
            String url = "http://localhost:4200/course-feedback?" + encodedParams;

            helper.setTo(to);
            helper.setSubject(subject);
            context.setVariable("feedbackUrl", url);
            String htmlContent = templateEngine.process(templateName, context);
            helper.setText(htmlContent, true);
            mailSender.send(mimeMessage);
        } catch (MessagingException | UnsupportedEncodingException e) {
            // Handle exception
        }
    }




    public void sendEmailToTrainerExtern(String to, String subject, String templateName, Context context, String externTrainerName) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");

        try {
            helper.setTo(to);
            helper.setSubject(subject);
            context.setVariable("externTrainerName", externTrainerName);
            String htmlContent = templateEngine.process(templateName,  context);
            helper.setText(htmlContent, true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            // Handle exception
        }
    }


}
