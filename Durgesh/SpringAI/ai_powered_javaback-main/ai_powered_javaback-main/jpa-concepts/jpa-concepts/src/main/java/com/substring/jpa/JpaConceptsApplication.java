package com.substring.jpa;

import com.substring.jpa.controller.TestController;
import com.substring.jpa.models.Student;
import com.substring.jpa.services.EmailService;
import com.substring.jpa.services.OrderService;
import com.substring.jpa.services.impl.MailstrapService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
public class JpaConceptsApplication {


    //spring boot project ka : starting point
    public static void main(String[] args) throws SQLException {

        //CONTEXT HI READY HO RAHA:
        var context = SpringApplication.run(JpaConceptsApplication.class, args);
        System.out.println("hi");
        TestController bean = context.getBean(TestController.class);
        System.out.println(bean);

        JdbcTemplate bean1 = context.getBean(JdbcTemplate.class);
        System.out.println(bean1);
        DataSource bean2 = context.getBean(DataSource.class);
        System.out.println(bean2);
        String url = bean2.getConnection().getMetaData().getURL();
        String userName = bean2.getConnection().getMetaData().getUserName();

        System.out.println(url);
        System.out.println(userName);

        Student bean3 = context.getBean(Student.class);
        System.out.println(bean3);
        bean3.eat();


        //internal:
//        context.getBean()

        var emailService = context.getBean(EmailService.class);
        emailService.sendEmail("Meeting for developers", "I want to conduct meeting on monday.", "teamLead@dev.in");


        var orderService=context.getBean(OrderService.class);
        orderService.sendInvoice();

    }

}
