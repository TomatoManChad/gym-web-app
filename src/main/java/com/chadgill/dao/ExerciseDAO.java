package com.chadgill.dao;

import java.io.IOException;
import java.util.List;

import com.chadgill.entity.Exercise;

public interface ExerciseDAO {
	
	

	/**gets all the existing exercises
	 * @return all exercises
	 * @throws IOException
	 */
	List<Exercise> getAllExercises() throws IOException;
	
	/**deletes the specified exercise
	 * @param theId id of exercise to be deleted
	 */
	public void deleteExercise(String theId);

	/**get a specific exercise
	 * @param theId the id of specified exercise
	 * @return the exercise
	 */
	Exercise getExercise(String theId);

}
