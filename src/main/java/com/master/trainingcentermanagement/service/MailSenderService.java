package com.master.trainingcentermanagement.service;

public interface MailSenderService {
    String sendNewMail(String to, String subject, String body);
}
