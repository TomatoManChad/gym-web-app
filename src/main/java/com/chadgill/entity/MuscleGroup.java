package com.chadgill.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "muscle_category")
public class MuscleGroup {
	
	
	
	@Id
	@Column(name = "name")
	private String name;
	
	@Column(name = "description", columnDefinition="text")
	private String description;
	
	/**Muscle group has many exercises
	 * 
	 */
	@OneToMany(mappedBy="muscleGroup", cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Exercise> exercises;
	
	
	public MuscleGroup() {
		
	}

	/**This contructs a muscle group with specified name and description of the muscle group
	 * @param name the name of muscle group
	 * @param description the description of muscle group
	 */
	public MuscleGroup(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}
	
	/**This method adds exercises to the muscle group
	 * @param tempExercise the exercise to be added
	 */
	public void add(Exercise tempExercise) {
		if (exercises == null) {
			exercises = new ArrayList<>();
		}
		exercises.add(tempExercise);
		tempExercise.setMuscleGroup(this);
	}

	@Override
	public String toString() {
		return "MuscleGroup [name=" + name + ", description=" + description + "]";
	}
	
	
}
