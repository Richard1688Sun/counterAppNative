package com.nemogz.CounterApp.repository;

import com.nemogz.CounterApp.databaseobjects.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String username);
}
