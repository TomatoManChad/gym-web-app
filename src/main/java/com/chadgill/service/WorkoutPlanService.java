package com.chadgill.service;

import java.util.List;

import com.chadgill.entity.WorkoutPlan;


public interface WorkoutPlanService {
	public List<WorkoutPlan> getWorkoutPlans();

	public void saveWorkoutPlan(WorkoutPlan theWorkoutPlan);

	public void deleteWorkout(int theId);
}
