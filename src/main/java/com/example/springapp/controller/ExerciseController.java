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

import com.example.springapp.model.Exercise;
import com.example.springapp.service.ExerciseServiceInterface;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {
	
	@Autowired
	private ExerciseServiceInterface service;
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Exercise e){
			
		boolean s=service.createExercise(e);
		if(s) {
			return new ResponseEntity<>("Exercise created", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Already present", HttpStatus.ALREADY_REPORTED);
	}
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody Exercise exercise){
			
		boolean s=service.updateExercise(exercise);
		if(s) {
			return new ResponseEntity<>("updated", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Exercise not found", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping
	public ResponseEntity<Boolean> delete(@RequestParam Long id){
			
		boolean s=service.deleteExercise(id);
		if(s) {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
		return new ResponseEntity<>(s, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping
	public ResponseEntity <List<Exercise>> getAll(){
			
		List <Exercise> exercise=service.getAllExercise();
		return new ResponseEntity<> (exercise, HttpStatus.OK);
	}
	
	@GetMapping("/id")
	public ResponseEntity<Exercise> getById(@RequestParam Long id){
			
		Exercise w=service.getExerciseById(id);
		if(w==null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(w, HttpStatus.OK);
	}
	@GetMapping("/workoutId")
	public ResponseEntity<List<Exercise>> getByWorkoutId(@RequestParam Long workoutId){
			
		List<Exercise> list=service.getExerciseByWorkoutId(workoutId);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
