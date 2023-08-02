package com.nemogz.CounterApp.controllers;

import com.nemogz.CounterApp.repository.UserRepository;
import com.nemogz.CounterApp.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserRepository repository;
    private final UserService service;

    public UserController(UserRepository repository, UserService service) {
        this.repository = repository;
        this.service = service;
    }
}
