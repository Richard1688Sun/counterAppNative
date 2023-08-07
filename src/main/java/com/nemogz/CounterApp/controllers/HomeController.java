package com.nemogz.CounterApp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }
}
