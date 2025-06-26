package com.api.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.blog.model.UserModel;
import com.api.blog.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserModel> register(@RequestBody UserModel userModel) {
		return ResponseEntity.ok(userService.registerUser(userModel));
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserModel userModel){
		return userService.loginUser(userModel.getEmail(), userModel.getPassword())
				.map(u-> ResponseEntity.ok("Login Successfully !"))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials"));
	}
}
