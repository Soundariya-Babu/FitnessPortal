package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springapp.model.User;
import com.example.springapp.repository.UserRepository;


@Service
public class UserServiceInterfaceImpl implements UserServiceInterface {

	@Autowired
	private UserRepository userRepo;
	
	public String passwordEncoder( String password)
	{
		return new BCryptPasswordEncoder().encode(password);
	}
	

	@Override
	public boolean registerUser(User user) {
		user.setPassword(passwordEncoder(user.getPassword()));
		return userRepo.save(user)!= null ? true : false;
	}

	@Override
	public boolean updateUser(User user) {
		if(userRepo.existsById(user.getId()))
		{
			return userRepo.save(user)!= null ? true : false;
		}
		return false;
	}

	@Override
	public boolean deleteUser(Long id) {
		if(userRepo.existsById(id))
		{
			userRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<User> getAllUser() {

		List<User> userList= userRepo.findAll();
		return userList;
	}

	@Override
	public User getUserById(Long id) {

		if(userRepo.existsById(id))
		{
			User user=userRepo.findById(id).get();
			return user;
		}
		
		return null;
	}

}
