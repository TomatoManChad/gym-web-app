package com.chadgill.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chadgill.dao.ExerciseDAO;
import com.chadgill.entity.Exercise;

@Service
@Transactional
public class ExerciseServiceImpl implements ExerciseService {

	@Autowired
	private ExerciseDAO exerciseDAO;

	@Transactional
	@Override
	public List<Exercise> getAllExercises() throws IOException {
		return exerciseDAO.getAllExercises();
	}

	@Transactional
	@Override
	public Exercise getExercise(String theId) {
		exerciseDAO.getExercise(theId);
		return exerciseDAO.getExercise(theId);
	}

}
