package com.kps.spring.model.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kps.spring.model.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);
}
