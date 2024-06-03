package com.example;

import java.security.Principal;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@RestController
public class SecurityQuickstartApplication {

	@GetMapping("/public")
	public String publicResource() {
		return "This is a public resource";
	}

	@GetMapping("/private")
	public String privateResource(Principal principal) {
		System.out.println("Principal: " + principal.getName());

		SecurityContext securityContext = SecurityContextHolder.getContext();
		String username = securityContext.getAuthentication().getName();
		System.out.println("Username: " + username);

		List<String> roles = securityContext.getAuthentication().getAuthorities().stream()
				.map(authority -> authority.getAuthority())
				.toList();

		System.out.println("Roles: " + roles);

		return "This is a private resource";
	}

	public static void main(String[] args) {
		SpringApplication.run(SecurityQuickstartApplication.class, args);
	}

}
