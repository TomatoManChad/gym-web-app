package com.chadgill.entity;

import java.util.ArrayList;
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
import javax.persistence.Table;

@Entity
@Table(name="workout_plan")
public class WorkoutPlan {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable (name="workoutplan_exercise", 
	joinColumns=@JoinColumn(name="workoutplan_id"),
	inverseJoinColumns=@JoinColumn(name="exercise_id"))
	private List <Exercise> exercises;
	
	public WorkoutPlan() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}
	
	public void addExercise (Exercise theExercise) {
		if (exercises == null) {
			exercises = new ArrayList<>();
		}
		exercises.add(theExercise);
	}



	@Override
	public String toString() {
		return "WorkoutPlan [id=" + id + ", name=" + name + ", exercises=" + exercises + "]";
	}


	
}
