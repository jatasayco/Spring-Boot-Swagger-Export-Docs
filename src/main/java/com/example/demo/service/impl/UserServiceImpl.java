package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository  userRepository;
	
	public UserServiceImpl(UserRepository  userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User findAll() {
		return userRepository.findAll();
	}
}
