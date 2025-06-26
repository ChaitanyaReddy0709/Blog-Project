package com.api.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.blog.model.UserModel;
import com.api.blog.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserModel registerUser(UserModel userModel) {
		return userRepository.save(userModel);
	}
	
	public Optional<UserModel> loginUser(String email, String password){
		return userRepository.findByEmail(email)
				.filter(u-> u.getPassword().equals(password));
	}
}
