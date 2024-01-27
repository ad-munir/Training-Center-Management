package com.master.trainingcentermanagement.service;

import org.thymeleaf.context.Context;

public interface MailSenderService {
    public void sendEmailWithHtmlTemplate(String to, String subject, String templateName, Context context, Long courseId, Long participantId) ;
}
