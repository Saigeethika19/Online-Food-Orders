package com.main.services;

import com.main.entity.UserRegistration;

public interface UserService {
	public UserRegistration createUser(UserRegistration user);
	public UserRegistration validateUser(String email, String password);
}
