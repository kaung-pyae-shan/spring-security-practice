package com.kps.spring.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.kps.spring.model.repo.UserRepo;

import lombok.RequiredArgsConstructor;

//@Component
@RequiredArgsConstructor
public class ApiUserDetailsService {

//	private final UserRepo userRepo;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		return userRepo.findByEmail(username)
//				.map(user -> User.builder()
//						.username(username)
//						.password(user.getPassword())
//						.authorities(user.getRole().name())
//						.build())
//				.orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
//	}

}
