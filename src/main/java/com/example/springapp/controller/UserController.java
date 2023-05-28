package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.User;
import com.example.springapp.service.UserServiceInterface;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceInterface userService;
	
	
	@PostMapping("/register")
	public ResponseEntity<String> save(@RequestBody User user){
			
		boolean s=userService.registerUser(user);
		if(s) {
			return new ResponseEntity<>("User Registered", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Already present", HttpStatus.ALREADY_REPORTED);
	}
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody User user){
			
		boolean s=userService.updateUser(user);
		if(s) {
			return new ResponseEntity<>("updated", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping
	public ResponseEntity<Boolean> delete(@RequestParam Long id){
			
		boolean s=userService.deleteUser(id);
		if(s) {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
		return new ResponseEntity<>(s, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping
	public ResponseEntity <List<User>> getAll(){
			
		List <User> users=userService.getAllUser();
		return new ResponseEntity<> (users, HttpStatus.OK);
	}
	
	@GetMapping("/id")
	public ResponseEntity<User> getById(@RequestParam Long id){
			
		User user=userService.getUserById(id);
		if(user==null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}
