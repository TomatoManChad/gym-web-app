package com.chadgill.dao;

import java.util.List;
import com.chadgill.entity.WorkoutPlan;

public interface WorkoutPlanDAO {
	
	public List<WorkoutPlan> getWorkoutPlans();

	
	public void saveWorkoutPlan(WorkoutPlan theWorkoutPlan);

	
	public void deleteWorkout(int theId);
}
