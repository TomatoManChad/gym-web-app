package com.chadgill.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chadgill.entity.WorkoutPlan;

@Repository
@Transactional
public interface WorkoutPlanDAO extends CrudRepository<WorkoutPlan, Integer> {
	

}
