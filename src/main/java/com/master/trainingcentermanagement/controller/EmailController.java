package com.master.trainingcentermanagement.controller;

import com.master.trainingcentermanagement.dto.EmailDto;
import com.master.trainingcentermanagement.service.impl.MailSenderServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.thymeleaf.context.Context;
import java.util.List;


@RestController
@RequestMapping("/api/v1/emails")
@RequiredArgsConstructor
public class EmailController {


    private final MailSenderServiceImp mailSenderServiceImp;


//    @PostMapping
//    public void sendEmails(@RequestBody List<EmailDto> emailDtos) {
//        for (EmailDto emailDto : emailDtos) {
//            mailSenderServiceImp.sendNewMail(emailDto.getTo(), emailDto.getSubject(), emailDto.getText());
//        }
//    }

    @PostMapping
    public String sendHtmlEmail(@RequestBody EmailDto emailDto) {
        Context context = new Context();
        context.setVariable("message", emailDto.getBody());

        mailSenderServiceImp.sendEmailWithHtmlTemplate(emailDto.getTo(), emailDto.getSubject(), "email-template", context);
        return "HTML email sent successfully!";
    }
}

