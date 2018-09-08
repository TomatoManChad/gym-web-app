package com.chadgill.service;

import java.io.IOException;
import java.util.List;

import com.chadgill.entity.Exercise;

public interface ExerciseService {

	/**this method communicated with the database to call all exercises. to be used by controller layer
	 * @return a list of all exercises from the database
	 * @throws IOException
	 */
	List<Exercise> getAllExercises() throws IOException;

	/**this method retrieves specified exercise based on id arguments. to be used in controller layer
	 * @param theId the specified id of exercise
	 * @return the exercise with specified id
	 */
	Exercise getExercise(String theId);

}
