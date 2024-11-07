package com.example.HUGOTravelPlanner.service;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Transactional
    public void createItenerary(String dbName) {
        String sql = "CREATE DATABASE IF NOT EXISTS Phone" + dbName;
        jdbcTemplate.execute(sql);
    }

    public void usephone(String phone){
        String sql = "USE Phone"+ phone;
        jdbcTemplate.execute(sql);
    }
}