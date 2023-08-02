package com.nemogz.CounterApp.repository;

import com.nemogz.CounterApp.databaseobjects.Counter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterRepository extends JpaRepository<Counter, Long> {
}
