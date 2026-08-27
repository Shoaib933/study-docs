package com.jpa.app.jpa_app.service;

import com.jpa.app.jpa_app.entity.User;
import com.jpa.app.jpa_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        User user1 = userRepository.save(user);
        System.out.println(user1.getUserId());
        System.out.println("user is saved:");


    }
}
