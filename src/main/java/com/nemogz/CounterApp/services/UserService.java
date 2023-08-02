package com.nemogz.CounterApp.services;

import com.nemogz.CounterApp.databaseobjects.User;
import com.nemogz.CounterApp.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService{
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * Verify new user has not counters attached
     * Reason: Counters need to be created first since they hold the foreign key
     * @param newUser
     * @return valid user creation
     */
    public boolean validCreateUser(User newUser) {
        return newUser.getCounters().isEmpty();
    }

}
