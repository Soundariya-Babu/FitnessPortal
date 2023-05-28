package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Exercise;


public interface ExerciseServiceInterface {

	 public boolean createExercise(Exercise e);
	 public boolean updateExercise( Exercise e);
	 public boolean deleteExercise(Long id);
	 public List<Exercise> getAllExercise();
	 public Exercise getExerciseById(Long id);
	 public List<Exercise> getExerciseByWorkoutId(Long workoutId);

}
