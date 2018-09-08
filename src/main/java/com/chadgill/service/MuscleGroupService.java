package com.chadgill.service;

import java.io.IOException;
import java.util.List;

import com.chadgill.entity.MuscleGroup;

public interface MuscleGroupService {
	/**inserts a specific muscle group
	 * @param theMuscleGroup the muscle group arguments
	 */
	public void insert(MuscleGroup theMuscleGroup);
	/**this method communicates with the database layer to retrieve all muscle groups, to be used by controller layer
	 * @return a list of all muscle groups
	 * @throws IOException
	 */
	public List<MuscleGroup> getAllMuscleGroups() throws IOException;
	public MuscleGroup getMuscleGroup(String theId);
}
