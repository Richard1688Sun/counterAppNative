package com.nemogz.CounterApp.services;

import com.nemogz.CounterApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.management.Query;

@Service
public class UserService{
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }
}
