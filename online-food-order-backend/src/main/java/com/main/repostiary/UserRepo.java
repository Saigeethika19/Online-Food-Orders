package com.main.repostiary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.UserRegistration;

public interface UserRepo  extends JpaRepository<UserRegistration, Integer>{
	UserRegistration findByEmailAndPassword(String email, String password);
}
