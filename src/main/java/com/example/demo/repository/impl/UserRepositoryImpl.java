package com.example.demo.repository.impl;

import org.springframework.stereotype.Repository;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{

	@Override
	public User findAll() {
		User u = new User();
		u.setId(1);
		u.setFirstName("Jair");
		return u;
	}
	
}
