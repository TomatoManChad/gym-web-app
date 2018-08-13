package com.chadgill.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.chadgill.dao.WorkoutPlanDAO;
import com.chadgill.entity.Exercise;
import com.chadgill.entity.WorkoutPlan;

@Service
public class WorkoutPlanServiceImpl  implements WorkoutPlanService{

	@Autowired
	private WorkoutPlanDAO workoutPlanDAO;
	


	
}
