package com.api.blog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.blog.model.UserModel;

public interface UserRepository extends JpaRepository <UserModel , Long> {
	Optional<UserModel> findByEmail(String email);
}
