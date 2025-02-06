package com.kps.spring.controller.output;

import com.kps.spring.model.entity.User.Role;

import lombok.Builder;

@Builder
public record SecurityInfo(
		String email,
		String name,
		Role role) {

}
