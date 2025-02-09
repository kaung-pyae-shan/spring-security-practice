package com.kps.spring.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private Role role;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<Product> products;
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<Category> categories;
	
	public enum Role {
		ADMIN, USER
	}
}
