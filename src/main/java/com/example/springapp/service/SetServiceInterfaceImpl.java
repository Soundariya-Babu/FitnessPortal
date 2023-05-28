package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Set;
import com.example.springapp.repository.SetRepository;

@Service
public class SetServiceInterfaceImpl implements SetServiceInterface {

	@Autowired
	private SetRepository setRepo;
	
	@Override
	public boolean createSet(Set s) {
		return setRepo.save(s)!= null ? true : false;
	}

	@Override
	public boolean updateSet(Set s) {
		if(setRepo.existsById(s.getId()))
		{
			return setRepo.save(s)!= null ? true : false;

		}
		return false;
	}

	@Override
	public boolean deleteSet(Long id) {
		if(setRepo.existsById(id))
		{
			setRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Set> getAllSet() {

		List<Set> s=setRepo.findAll();
		return s;
	}

	@Override
	public Set getSetById(Long id) {
		
		if(setRepo.existsById(id))
		{
			Set s=setRepo.findById(id).get();
			return s;
		}		
		return null;
	}

	@Override
	public List<Set> getSetByExerciseId(Long exerciseId) {

		List<Set> list=setRepo.findByExerciseId(exerciseId);
		return list;
	}

}
