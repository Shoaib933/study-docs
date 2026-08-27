package com.substring.jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ProductService
{

    private final JdbcTemplate jdbcTemplate;

    private final  JdbcClient jdbcClient;

    //spring boot project:
//    @Autowired
    public ProductService(JdbcTemplate jdbcTemplate, JdbcClient jdbcClient) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcClient = jdbcClient;

    }


}
