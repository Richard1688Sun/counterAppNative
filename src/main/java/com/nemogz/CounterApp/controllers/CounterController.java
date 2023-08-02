package com.nemogz.CounterApp.controllers;

import com.nemogz.CounterApp.repository.CounterRepository;
import com.nemogz.CounterApp.services.CounterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/counter")
public class CounterController {

    private final CounterRepository repository;
    private final CounterService service;

    public CounterController(CounterRepository repository, CounterService service) {
        this.repository = repository;
        this.service = service;
    }
}
