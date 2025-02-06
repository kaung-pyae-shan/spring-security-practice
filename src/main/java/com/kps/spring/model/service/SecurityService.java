package com.kps.spring.model.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kps.spring.controller.input.SignUpForm;
import com.kps.spring.controller.output.SecurityInfo;
import com.kps.spring.exceptions.ApiBusinessException;
import com.kps.spring.model.entity.User;
import com.kps.spring.model.repo.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecurityService {

	private final AuthenticationManager authenticationManager;
	private final UserRepo userRepo;
	private final PasswordEncoder passwordEncoder;
	
	public SecurityInfo signUp(SignUpForm form) {
		if(userRepo.findByEmail(form.email()).isPresent()) {
			throw new ApiBusinessException("Your account is already registered. Please check your email.");
		}
		
		var user = userRepo.save(form.entity(passwordEncoder::encode));
		var authentication = authenticationManager.authenticate(form.authentication());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return getResult(user);
	}
	
	private SecurityInfo getResult(User user) {
		return SecurityInfo.builder()
				.email(user.getEmail())
				.name(user.getName())
				.role(user.getRole())
				.build();
	}
}
