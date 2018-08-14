package com.chadgill.service;

import java.io.IOException;
import java.util.List;

import com.chadgill.entity.Exercise;

public interface ExerciseService {

	List<Exercise> getAllExercises() throws IOException;

	Exercise getExercise(String theId);

}
