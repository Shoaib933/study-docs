package com.substring.jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    @Qualifier("adityaEmailService")
    private EmailService emailService;


    //invoice email:
    public void sendInvoice() {
        IO.println("sending invoice");
        emailService.sendEmail("Invoice for product 123124", "This is invoice for product you have taken", "vivek@gmail.com");
    }
}
