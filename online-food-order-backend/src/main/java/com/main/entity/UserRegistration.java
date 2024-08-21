package com.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "User")
public class UserRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@NotEmpty(message = "Name Should not be Empty")
//	@Size(min = 4,message = "Must Container atlease four Character")
	private String name;
	
//	@NotEmpty(message = "Email Should not be Empty")
	private String email;
//	
//	@NotEmpty(message = "Not Be Empty")
//	@Size(min = 10,max = 10,message = "Not Valid Phone Number")
	private String number;
	
//	@Size(min = 5,max = 12,message = "Invalid Password must contain atleast four Character")
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	

}
