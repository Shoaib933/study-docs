package com.myparac.DockerDemo.cotroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController

public class MyController {

    @RequestMapping("/")
    public Map<String, Object> myapi() {
        Map<String, Object> data = new HashMap<>();
        data.put("message", "Java api is workinhg fine");
        data.put("languages", Arrays.asList("java", "python", "php", "Golang"));
        data.put("code", "2354");
        return data;
    }
}
