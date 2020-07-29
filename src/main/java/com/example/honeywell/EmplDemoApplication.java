package com.example.honeywell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.*")
public class EmplDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmplDemoApplication.class, args);
	}

}
