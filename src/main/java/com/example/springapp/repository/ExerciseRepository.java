package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

	public List<Exercise> findByWorkoutId(Long workoutId);
}
