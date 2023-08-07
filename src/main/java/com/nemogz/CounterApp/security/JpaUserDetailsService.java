package com.nemogz.CounterApp.security;

import com.nemogz.CounterApp.repository.UserRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@SpringBootApplication
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var test =  userRepository
                .findByUserName(username)
                .map(UserDetailsSecurity:: new)
                .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + "NOT FOUND!"));
        return test;
    }
}
