package com.chadgill.service;

import java.io.IOException;
import java.util.List;

import com.chadgill.entity.MuscleGroup;

public interface MuscleGroupService {
	public void insert(MuscleGroup theMuscleGroup);
	public List<MuscleGroup> getAllMuscleGroups() throws IOException;
	public MuscleGroup getMuscleGroup(String theId);
}
