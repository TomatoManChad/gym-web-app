package com.chadgill.dao;

import java.io.IOException;
import java.util.List;
import com.chadgill.entity.Exercise;
import com.chadgill.entity.MuscleGroup;

public interface MuscleGroupDAO {
	
public void insert(MuscleGroup theMuscleGroup);

/**populates and retrieves all muscle groups
 * @return the muscle group
 * @throws IOException
 */
public List<MuscleGroup> getAllMuscleGroups() throws IOException;

/**retrieve a specific muscle group
 * @param theId the id of muscle group
 * @return the muscle group 
 */
MuscleGroup getMuscleGroup(String theId);


}
