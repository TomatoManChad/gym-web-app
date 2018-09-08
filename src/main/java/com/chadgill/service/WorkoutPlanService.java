package com.chadgill.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.chadgill.entity.Exercise;
import com.chadgill.entity.User;
import com.chadgill.entity.WorkoutPlan;


public interface WorkoutPlanService {
	
	/**saves the workout plan to the database
	 * @param workout the workout plan arguments
	 */
	public void save (WorkoutPlan workout);
	
	/**this method gets a specific workout based on its id
	 * @param workoutId the id of workout
	 * @return this workout object
	 */
	public Optional<WorkoutPlan> findById(int workoutId);
	
	/**deletes the workout based on specified id
	 * @param workoutId the id of the specific workout
	 * @return this workout id to delete from database
	 */
	public int deleteById(int workoutId);
	
	/**this retrieves all the workout plans stored in the database
	 * @return list of workout plans
	 */
	public List<WorkoutPlan> findAll();
	

}
