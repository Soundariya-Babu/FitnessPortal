package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Workout;
import com.example.springapp.repository.WorkoutRepository;

@Service
public class WorkoutServiceInterfaceImpl implements WorkoutServiceInterface {

	
	@Autowired
	private WorkoutRepository workoutRepo;
	
	@Override
	public boolean createWorkout(Workout workout) {
		return workoutRepo.save(workout)!= null ? true : false;
	}

	@Override
	public boolean updateWorkout(Workout workout) {

		if(workoutRepo.existsById(workout.getId()))
		{
			return workoutRepo.save(workout)!= null ? true : false;
		}
		return false;
	}

	@Override
	public boolean deleteWorkout(Long id) {
		if(workoutRepo.existsById(id))		
		{
			workoutRepo.deleteById(id);
			return true;
		}
			return false;
	}

	@Override
	public List<Workout> getAllWorkout() {

		List<Workout> list=workoutRepo.findAll();
		return list;
	}

	@Override
	public Workout getWorkoutById(Long id) {
		if(workoutRepo.existsById(id))
		{
			Workout u=workoutRepo.findById(id).get();
			return u;
		}
		return null;
	}

	@Override
	public List<Workout> getWorkOutByUserId(Long userId) {

		List<Workout> list=workoutRepo.findByUserId(userId);

		return list;
	}

}
