package com.nemogz.CounterApp.services;

import com.nemogz.CounterApp.databaseobjects.User;
import com.nemogz.CounterApp.exceptions.DuplicateUserNameException;
import com.nemogz.CounterApp.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService{
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * Verify new user
     *  -  has not counters attached
     *  -
     * Reason: Counters need to be created first since they hold the foreign key
     * @param newUser
     */
    public void checkCreateUser(User newUser) throws DuplicateUserNameException {
        if (repository.findByUserName(newUser.getUserName()).isPresent()) {
            throw new DuplicateUserNameException();
        }
//        return newUser.getCounters().isEmpty();
    }

}
