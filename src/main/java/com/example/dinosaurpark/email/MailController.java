package com.example.dinosaurpark.email;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mail")
public class MailController {
    private final MailService mailService;

    @PostMapping(produces = "application/json")
    public ResponseEntity<String> execMail(@RequestBody MailDto mailDto) {
        mailService.mailSend(mailDto);
        return ResponseEntity.status(HttpStatus.OK).body("mail sent successfully");
    }
    
}
