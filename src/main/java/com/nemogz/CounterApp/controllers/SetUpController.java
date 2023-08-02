package com.nemogz.CounterApp.controllers;

import com.nemogz.CounterApp.databaseobjects.Counter;
import com.nemogz.CounterApp.databaseobjects.User;
import com.nemogz.CounterApp.repository.CounterRepository;
import com.nemogz.CounterApp.repository.UserRepository;
import com.nemogz.CounterApp.services.CounterService;
import com.nemogz.CounterApp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Optional;

@RestController
@RequestMapping(path = "/setup")
public class SetUpController {

    private final UserRepository userRepository;
    private final UserService userService;

    private final CounterRepository counterRepository;
    private final CounterService counterService;

    public SetUpController(UserRepository userRepository, UserService userService, CounterRepository counterRepository, CounterService counterService) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.counterRepository = counterRepository;
        this.counterService = counterService;
    }

    @PostMapping("/user")
    ResponseEntity<String> newUser(@RequestBody User newUser) {
        if (userService.validCreateUser(newUser)) {
            User result = userRepository.save(newUser);
            return new ResponseEntity<>("User: " + result.getUserName() + " created", HttpStatus.OK);
        }
        return new ResponseEntity<>("user creation failed: has attached counters", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @PostMapping("/littleHouse")
    ResponseEntity<String> littleHouseSetUp(@RequestBody User user) {

        Optional<User> userOptional = userRepository.findById(user.getId());


        Counter[] counters = counterService.getBasicLittleHouseCounters(user);
        counterRepository.saveAll(Arrays.asList(counters));
        return new ResponseEntity<>("Little House Counters Created", HttpStatus.OK);
    }

}
