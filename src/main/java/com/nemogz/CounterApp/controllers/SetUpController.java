package com.nemogz.CounterApp.controllers;

import com.nemogz.CounterApp.databaseobjects.Counter;
import com.nemogz.CounterApp.databaseobjects.User;
import com.nemogz.CounterApp.exceptions.DuplicateUserNameException;
import com.nemogz.CounterApp.repository.CounterRepository;
import com.nemogz.CounterApp.repository.UserRepository;
import com.nemogz.CounterApp.services.CounterService;
import com.nemogz.CounterApp.services.TokenService;
import com.nemogz.CounterApp.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static com.nemogz.CounterApp.config.SpringSecurityConfig.passwordEncoder;

@RestController
@RequestMapping(path = "/setup")
public class SetUpController {

    private static final Logger LOG = LoggerFactory.getLogger(SetUpController.class);
    private final UserRepository userRepository;
    private final UserService userService;

    private final CounterRepository counterRepository;
    private final CounterService counterService;

    private final TokenService tokenService;

    public SetUpController(UserRepository userRepository, UserService userService, CounterRepository counterRepository, CounterService counterService, TokenService tokenService) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.counterRepository = counterRepository;
        this.counterService = counterService;
        this.tokenService = tokenService;
    }

    /**
     * Creating new user
     * @param newUser
     * @return
     */
    @PostMapping("/new-user")
    ResponseEntity<String> newUser(@RequestBody User newUser) {
        if (newUser.getUserName() == null) {
            return new ResponseEntity<>("Invalid Parameters", HttpStatus.BAD_REQUEST);
        }

        try {
            userService.checkCreateUser(newUser);
        } catch (DuplicateUserNameException e) {
            return new ResponseEntity<>("User: " + newUser.getUserName() + "already exists", HttpStatus.BAD_REQUEST);
        }

        newUser.setDateCreated(LocalDateTime.now());
        newUser.setPassword(passwordEncoder().encode(newUser.getPassword()));
        newUser.setCounters(null);
        newUser.setLittleHouse(null);
        newUser.setHomework(null);
        User result = null;
        try {
            result = userRepository.save(newUser);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Invalid Parameters", HttpStatus.BAD_REQUEST);
        }

        userRepository.findByUserName(newUser.getUserName());
        return new ResponseEntity<>("User: " + result.getUserName() + " created", HttpStatus.OK);
    }

    /**
     * Returning the JWT for authorization
     * @param authentication
     * @return
     */
    @PostMapping("/token")
    String token(Authentication authentication) {
        LOG.debug("Token request for user: '{}'", authentication);
        String token = tokenService.generateToken(authentication);
        LOG.debug("Token created {}", token);
        return token;
    }

    /**
     * Setting up littleHouse counter for user
     * @return
     */
    @PostMapping("/littleHouse")
    ResponseEntity<String> littleHouseSetUp(Authentication authentication) {

        // safe way to handle null exceptions
        Optional<User> userOptional = userRepository.findByUserName(authentication.getName());

        if (userOptional.isPresent()) {
            Counter[] counters = counterService.getBasicLittleHouseCounters(userOptional.get());
            counterRepository.saveAll(Arrays.asList(counters));
            return new ResponseEntity<>("Little House Counters Created", HttpStatus.OK);
        }
        return new ResponseEntity<>("[Error]Little House Counters NOT Created", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /**
     *Setting up homework counter for user
     * @param userId
     * @return
     */
    @PostMapping("/homework")
    ResponseEntity<String> homeworkSetUp (@RequestBody Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            return new ResponseEntity<>("Homework Coutner Created", HttpStatus.OK);
        }
        return new ResponseEntity<>("Homework Coutner Created", HttpStatus.UNPROCESSABLE_ENTITY);

    }
}
