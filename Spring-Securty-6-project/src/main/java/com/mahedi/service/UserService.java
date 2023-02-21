package com.mahedi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mahedi.entity.User;
import com.mahedi.repository.UserRepository;
@Service
public class UserService {

	@Autowired
	PasswordEncoder crypt;
	@Autowired
	private UserRepository userRepository;

	public User saveusers(User user) {
		user.setPassword(crypt.encode(user.getPassword()));
		return userRepository.save(user);
	}

	public List<User> getUserAll() {
		
		return userRepository.findAll();
	}

//	public User getUser(String username) {
//		
//		return userRepository.findByUsername(username);
//	}

	
}
