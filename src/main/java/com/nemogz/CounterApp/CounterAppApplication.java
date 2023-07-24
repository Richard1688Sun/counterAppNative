package com.nemogz.CounterApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication
public class CounterAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CounterAppApplication.class, args);
	}

}
