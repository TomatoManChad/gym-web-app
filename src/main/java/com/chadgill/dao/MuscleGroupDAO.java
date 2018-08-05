package com.chadgill.dao;

import java.io.IOException;
import java.util.List;
import com.chadgill.entity.Exercise;
import com.chadgill.entity.MuscleGroup;

public interface MuscleGroupDAO {
public void insert(MuscleGroup theMuscleGroup);

public List<MuscleGroup> getAllMuscleGroups() throws IOException;

MuscleGroup getMuscleGroup(String theId);


}
