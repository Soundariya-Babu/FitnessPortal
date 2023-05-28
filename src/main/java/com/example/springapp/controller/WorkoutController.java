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

import com.example.springapp.model.Workout;
import com.example.springapp.service.WorkoutServiceInterface;

@RestController
@RequestMapping("/workout")
public class WorkoutController {
	
	@Autowired
	private WorkoutServiceInterface workoutService;
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Workout workout){
			
		boolean s=workoutService.createWorkout(workout);
		if(s) {
			return new ResponseEntity<>("workout created", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Already present", HttpStatus.ALREADY_REPORTED);
	}
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody Workout workout){
			
		boolean s=workoutService.updateWorkout(workout);
		if(s) {
			return new ResponseEntity<>("updated", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("workout not found", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping
	public ResponseEntity<Boolean> delete(@RequestParam Long id){
			
		boolean s=workoutService.deleteWorkout(id);
		if(s) {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
		return new ResponseEntity<>(s, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping
	public ResponseEntity <List<Workout>> getAll(){
			
		List <Workout> workouts=workoutService.getAllWorkout();
		return new ResponseEntity<> (workouts, HttpStatus.OK);
	}
	
	@GetMapping("/id")
	public ResponseEntity<Workout> getById(@RequestParam Long id){
			
		Workout w=workoutService.getWorkoutById(id);
		if(w==null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(w, HttpStatus.OK);
	}
	@GetMapping("/userId")
	public ResponseEntity<List<Workout>> getByWorkoutId(@RequestParam Long userId){
			
		List<Workout> list=workoutService.getWorkOutByUserId(userId);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
