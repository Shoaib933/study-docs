package com.substring.jpa.services.impl;

import com.substring.jpa.services.EmailService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import static java.lang.IO.println;

@Service
public class ResendEmailService implements EmailService {
    @Override
    public void sendEmail(String sub, String body, String toEmail) {
        //logic to send email:
        //mailstrap
        println("Sending Resend");
        println("sending email "+toEmail +" Subject : "+sub +"\n Body: "+body);


    }
}
