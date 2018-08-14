package com.chadgill.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chadgill.dao.MuscleGroupDAO;
import com.chadgill.entity.MuscleGroup;

@Service
@Transactional
public class MuscleGroupServiceImpl implements MuscleGroupService {

	@Autowired
	private MuscleGroupDAO muscleGroupDAO;

	@Override
	public void insert(MuscleGroup theMuscleGroup) {
		muscleGroupDAO.insert(theMuscleGroup);

	}

	@Transactional
	@Override
	public List<MuscleGroup> getAllMuscleGroups() throws IOException {
		return muscleGroupDAO.getAllMuscleGroups();
	}

	@Transactional
	@Override
	public MuscleGroup getMuscleGroup(String theId) {
		muscleGroupDAO.getMuscleGroup(theId);
		return muscleGroupDAO.getMuscleGroup(theId);
	}

}
