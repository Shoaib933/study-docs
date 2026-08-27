package com.jpa.app.jpa_app;

import com.jpa.app.jpa_app.entity.User;
import com.jpa.app.jpa_app.repository.UserRepository;
import com.jpa.app.jpa_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaAppApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaAppApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("app started");
//        var user=new User();
//        user.setUserId(12412);
//        user.setName("Abhinav");
//        user.setEmail("abhinav@dev.in");
//        userService.saveUser(user);
        userRepository.findAll().forEach(item->{
            IO.println(item.getName());
        });
    }
}
