package com.substring.jpa.config;

import com.substring.jpa.models.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean
    @Primary
    public Student student(){
        return new Student();
    }
}
