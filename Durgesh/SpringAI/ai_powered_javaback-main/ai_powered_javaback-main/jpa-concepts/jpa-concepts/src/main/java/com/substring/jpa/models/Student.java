package com.substring.jpa.models;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class Student {
    public Student(){
        System.out.println("Student created");
    }
    public void eat(){
        System.out.println("student is eating");
    }
}
