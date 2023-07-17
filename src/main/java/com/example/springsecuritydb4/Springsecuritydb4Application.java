package com.example.springsecuritydb4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class Springsecuritydb4Application {

	public static void main(String[] args) {
		SpringApplication.run(Springsecuritydb4Application.class, args);
	}
	@GetMapping("/user")
	public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name ){
		return String.format("Users Hello %s!", name);
	}

	@GetMapping("/admin")
	public String sayAdmin(@RequestParam(value = "myName", defaultValue = "World") String name ){
		return String.format("admin Hello %s!", name);
	}
}
