package com.example.dinosaurpark.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MailService {

    private JavaMailSender javaMailSender;

    @Async
    public void mailSend(MailDto mailDto) {
        for (String address : mailDto.getAddresses()) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(address);
            message.setSubject(mailDto.getTitle());
            message.setText(mailDto.getMessage());
            javaMailSender.send(message);
        }
    }

}
