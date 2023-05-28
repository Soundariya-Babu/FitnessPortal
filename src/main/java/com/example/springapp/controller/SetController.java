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

import com.example.springapp.model.Set;
import com.example.springapp.service.SetServiceInterface;

@RestController
@RequestMapping("/set")
public class SetController {
	
	@Autowired
	private SetServiceInterface service;
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Set e){
			
		boolean s=service.createSet(e);
		if(s) {
			return new ResponseEntity<>("Set created", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Already present", HttpStatus.ALREADY_REPORTED);
	}
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody Set set){
			
		boolean s=service.updateSet(set);
		if(s) {
			return new ResponseEntity<>("updated", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Set not found", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping
	public ResponseEntity<Boolean> delete(@RequestParam Long id){
			
		boolean s=service.deleteSet(id);
		if(s) {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
		return new ResponseEntity<>(s, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping
	public ResponseEntity <List<Set>> getAll(){
			
		List <Set> set=service.getAllSet();
		return new ResponseEntity<> (set, HttpStatus.OK);
	}
	
	@GetMapping("/id")
	public ResponseEntity<Set> getById(@RequestParam Long id){
			
		Set w=service.getSetById(id);
		if(w==null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(w, HttpStatus.OK);
	}
	@GetMapping("/exerciseId")
	public ResponseEntity<List<Set>> getByWorkoutId(@RequestParam Long exerciseId){
			
		List<Set> list=service.getSetByExerciseId(exerciseId);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
