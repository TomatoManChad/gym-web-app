package com.chadgill.dao;

import java.io.IOException;
import java.util.List;

import com.chadgill.entity.Exercise;

public interface ExerciseDAO {

	List<Exercise> getAllExercises() throws IOException;
	
	public void deleteExercise(int theId);

}
