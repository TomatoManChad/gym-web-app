package com.chadgill.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.chadgill.entity.Exercise;
import com.chadgill.entity.User;
import com.chadgill.entity.WorkoutPlan;


public interface WorkoutPlanService {
	
	public void save (WorkoutPlan workout);
	public Optional<WorkoutPlan> findById(int workoutId);
	public int deleteById(int workoutId);
	public List<WorkoutPlan> findAll();
	

}
