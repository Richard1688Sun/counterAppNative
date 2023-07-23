package com.nemogz.CounterApp.repository;

import com.nemogz.CounterApp.databaseobjects.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
