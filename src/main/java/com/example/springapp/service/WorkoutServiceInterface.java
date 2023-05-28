package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Workout;


public interface WorkoutServiceInterface {

	 public boolean createWorkout(Workout workout);
	 public boolean updateWorkout( Workout workout);
	 public boolean deleteWorkout(Long id);
	 public List<Workout> getAllWorkout();
	 public Workout getWorkoutById(Long id);
	 public List<Workout> getWorkOutByUserId(Long userId);
}
