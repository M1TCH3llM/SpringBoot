package com.synergisticit.service;

import java.util.List;

import com.synergisticit.domain.User;

public interface UserService {

	User save(User user);
	User findById(int userId);
	List<User> findAll();
	User updateUserById(int userId);
	void deleteById(int userId);


	
}
