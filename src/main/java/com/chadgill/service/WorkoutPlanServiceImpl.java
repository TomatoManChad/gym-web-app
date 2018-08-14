package com.chadgill.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chadgill.dao.UserDAO;
import com.chadgill.dao.WorkoutPlanDAO;
import com.chadgill.entity.Exercise;
import com.chadgill.entity.WorkoutPlan;

@Service
@Transactional
public class WorkoutPlanServiceImpl implements WorkoutPlanService {

	@Autowired
	private WorkoutPlanDAO workoutPlanDAO;

	public WorkoutPlanServiceImpl(WorkoutPlanDAO workoutPlanDAO) {
		this.workoutPlanDAO = workoutPlanDAO;
	}

	@Override
	public void save(WorkoutPlan workout) {
		workoutPlanDAO.save(workout);

	}

	@Override
	public Optional<WorkoutPlan> findById(int workoutId) {
		return workoutPlanDAO.findById(workoutId);

	}

	@Override
	public int deleteById(int workoutId) {
		workoutPlanDAO.deleteById(workoutId);
		return workoutId;

	}

}
