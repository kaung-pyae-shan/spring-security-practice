package com.kps.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kps.spring.controller.input.SignUpForm;
import com.kps.spring.controller.output.SecurityInfo;
import com.kps.spring.model.service.SecurityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class SecurityController {

	private final SecurityService securityService;
	
	@GetMapping
	public String auth() {
		return "Auth";
	}
	
	@PostMapping("/signUp")
	public SecurityInfo signUp(@Validated @RequestBody SignUpForm signUpForm, BindingResult result) {
		if (result.hasErrors()) {
			throw new IllegalArgumentException("Invalid form");
		}
		return securityService.signUp(signUpForm);
	}

}
