package com.chadgill.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exercise")
public class Exercise {

	@Id
	@Column(name = "name")
	private String name;

	@Column(name = "instructions", columnDefinition="text")
	private String instructions;

	@Column(name = "video")
	private String video;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "muscle_category_name")
	private MuscleGroup muscleGroup;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(name="workoutplan_exercise",
	joinColumns=@JoinColumn(name="exercise_id"),
	inverseJoinColumns=@JoinColumn(name="workoutplan_id"))
	private List<WorkoutPlan> workoutPlans;
	
	public Exercise() {

	}

	public Exercise(String name, String instructions, String video) {
		this.name = name;
		this.instructions = instructions;
		this.video = video;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public MuscleGroup getMuscleGroup() {
		return muscleGroup;
	}

	public void setMuscleGroup(MuscleGroup muscleGroup) {
		this.muscleGroup = muscleGroup;
	}
	
	public List<WorkoutPlan> getWorkoutPlans() {
		return workoutPlans;
	}

	public void setWorkoutPlans(List<WorkoutPlan> workoutPlans) {
		this.workoutPlans = workoutPlans;
	}

	@Override
	public String toString() {
		return "Exercise [name=" + name + ", instructions=" + instructions + ", video=" + video
				+ ", muscleGroup=" + muscleGroup + "]";
	}
}