package com.synergisticit.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.User;
import com.synergisticit.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired UserRepository userRepository;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findById(int userId) {
		Optional<User> optUser = userRepository.findById(userId);
		if(optUser.isPresent()) {
			return optUser.get();
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User updateUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int userId) {
		userRepository.deleteById(userId);

	}

}
