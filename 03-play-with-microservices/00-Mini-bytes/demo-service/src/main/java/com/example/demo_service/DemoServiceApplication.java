package com.example.demo_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class DemoServiceApplication {

	@GetMapping("/users")
	public Mono<String> getUsers() {
		String userServiceUrl = "http://localhost:8080/users";
		// using web client to call another service
		WebClient webClient = WebClient.create(userServiceUrl);
		Mono<String> response = webClient.get().retrieve().bodyToMono(String.class);
		return response;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoServiceApplication.class, args);
	}

}
