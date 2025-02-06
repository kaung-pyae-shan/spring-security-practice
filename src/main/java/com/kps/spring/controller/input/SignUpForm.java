package com.kps.spring.controller.input;

import java.util.function.Function;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.kps.spring.model.entity.User;

import jakarta.validation.constraints.NotBlank;

public record SignUpForm(
		@NotBlank(message = "Please enter name") String name,
		@NotBlank(message = "Please enter email") String email,
		@NotBlank(message = "Please enter password") String password) {

	public User entity(Function<String, String> encoder) {
		return User.builder()
				.name(name)
                .email(email)
                .password(encoder.apply(password))
                .role(User.Role.USER)
                .build();
	}
	
	public Authentication authentication() {
		return UsernamePasswordAuthenticationToken.unauthenticated(name, email);
	}

}
