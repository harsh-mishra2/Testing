package com.JunitTesting.repository;

import java.util.Optional;

import com.JunitTesting.entity.User;



public interface UserRepository {
    Optional<User> findById(int id);
}