package com.example.dinosaurpark.email;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MailDto {
    private List<String> addresses;
    private String title;
    private String message;
}
