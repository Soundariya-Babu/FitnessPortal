package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Set;


public interface SetServiceInterface {

	 public boolean createSet(Set s);
	 public boolean updateSet( Set s);
	 public boolean deleteSet(Long id);
	 public List<Set> getAllSet();
	 public Set getSetById(Long id);
	 public List<Set> getSetByExerciseId(Long exerciseId);
}
