package com.synergisticit.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	@NotEmpty
	private String username;
	
	@NotEmpty

	private String password;
	
	@Email
	@NotEmpty
	private String email;
	
	@ManyToMany
	@JoinTable(name="user_role", joinColumns= {@JoinColumn(name="user_Id")}, inverseJoinColumns= {@JoinColumn(name="role_Id")})
	List<Role> roles= new ArrayList<>();
	
}
