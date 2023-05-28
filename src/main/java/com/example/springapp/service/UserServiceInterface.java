package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.User;


public interface UserServiceInterface {

	 public boolean registerUser(User user);
	 public boolean updateUser( User User);
	 public boolean deleteUser(Long id);
	 public List<User> getAllUser();
	 public User getUserById(Long id);
}
