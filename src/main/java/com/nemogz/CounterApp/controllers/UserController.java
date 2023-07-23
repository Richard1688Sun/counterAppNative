package com.nemogz.CounterApp.controllers;

import com.nemogz.CounterApp.databaseobjects.User;
import com.nemogz.CounterApp.repository.UserRepository;
import com.nemogz.CounterApp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository repository;
    private final UserService service;

    public UserController(UserRepository repository, UserService service) {
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("/user")
    ResponseEntity<String> newUser(@RequestBody User newUser) {
        User result = repository.save(newUser);
        return new ResponseEntity<>("user created", HttpStatus.OK);
    }
}
