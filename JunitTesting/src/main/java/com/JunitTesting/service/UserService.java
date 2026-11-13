package com.JunitTesting.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.JunitTesting.entity.User;
import com.JunitTesting.repository.UserRepository;


@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public String getUserName(int id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            return user.get().getName();
        } else {
            return "Unknown User";
        }
    }
}