package com.nemogz.CounterApp;

import com.nemogz.CounterApp.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class CounterAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CounterAppApplication.class, args);
	}

}
