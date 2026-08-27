package com.substring.jpa.services;

public interface EmailService {


    default void sendEmail(String sub, String body, String toEmail)
    {
        System.out.println("Sending mail using default : way");
    }


}
