package com.example.demojava1.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    public void sendCode(String toEmail, String name) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("elnur.kaziullaev.05@gmail.com");
        message.setTo(toEmail);
        message.setSubject("Kaziullayev Yelnur");
        message.setText(name);
        mailSender.send(message);
    }
}