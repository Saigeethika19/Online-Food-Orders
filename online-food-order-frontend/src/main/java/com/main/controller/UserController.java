package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.UserRegistration;
import com.main.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create-user")
	public ResponseEntity<UserRegistration>createUser(@RequestBody UserRegistration user)
	{
		UserRegistration savedUser = userService.createUser(user);
		return new ResponseEntity<>(savedUser,HttpStatus.OK);
	}

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserRegistration user) {
        UserRegistration foundUser = userService.validateUser(user.getEmail(), user.getPassword());
        if (foundUser != null) {
            // You might want to return a token or some user details here
            return new ResponseEntity<>(foundUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
    }
}
