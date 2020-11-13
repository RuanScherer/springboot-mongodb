package com.ruanscherer.springboot_mongodb.services;

import com.ruanscherer.springboot_mongodb.domain.User;
import com.ruanscherer.springboot_mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
