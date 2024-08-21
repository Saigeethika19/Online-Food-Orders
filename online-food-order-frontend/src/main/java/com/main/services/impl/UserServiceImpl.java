package com.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.UserRegistration;
import com.main.repostiary.UserRepo;
import com.main.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Override
	public UserRegistration createUser(UserRegistration user) {
		UserRegistration saveUser = userRepo.save(user);
		return saveUser;
	}
	@Override
	public UserRegistration validateUser(String email, String password) {
        return userRepo.findByEmailAndPassword(email, password);
    }

}
