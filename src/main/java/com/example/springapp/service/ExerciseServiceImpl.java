package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Exercise;
import com.example.springapp.repository.ExerciseRepository;

@Service
public class ExerciseServiceImpl implements ExerciseServiceInterface {

	@Autowired
	private ExerciseRepository exRepo;
	
	@Override
	public boolean createExercise(Exercise e) {
		return exRepo.save(e)!= null ? true : false;
	}

	@Override
	public boolean updateExercise(Exercise e) {
		if(exRepo.existsById(e.getId()))
		{
			return exRepo.save(e)!= null ? true : false;

		}
		return false;
	}

	@Override
	public boolean deleteExercise(Long id) {
		if(exRepo.existsById(id))
		{
			exRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Exercise> getAllExercise() {

		List<Exercise> exercise=exRepo.findAll();
		return exercise;
	}

	@Override
	public Exercise getExerciseById(Long id) {

		if(exRepo.existsById(id))
		{
			Exercise ex=exRepo.findById(id).get();
			return ex;
		}
		return null;
	}

	@Override
	public List<Exercise> getExerciseByWorkoutId(Long workoutId) {
          List<Exercise> list=exRepo.findByWorkoutId(workoutId);
		return list;
	}

}
