package com.substring.jpa.services.impl;

import com.substring.jpa.services.EmailService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import static  java.lang.IO.*;
@Service
@Primary
public class MailstrapService implements EmailService {

    //mailstrap
    @Override
    public void sendEmail(String subject, String body, String toEmail){
        //logic to send email:
        //mailstrap
        println("Sending mailstrap");
        println("sending email "+toEmail +" Subject : "+subject +"\n Body: "+body);


    }
}
