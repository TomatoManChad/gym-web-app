package com.chadgill.entity;

import javax.validation.constraints.NotNull;

public class AddWorkoutPlanItemForm {

	@NotNull
	private int workoutId;
	
	@NotNull
	private String exerciseId;
	
	private Iterable<Exercise> exercises;
	
	private WorkoutPlan workoutPlan;
	
	public AddWorkoutPlanItemForm() {}
	
	/**This constructs an iterator of exercises with the assosiated workout plan
	 * @param exercises the exercises
	 * @param workoutPlan the workout plan
	 */
	public AddWorkoutPlanItemForm(Iterable<Exercise> exercises, WorkoutPlan workoutPlan) {
		this.exercises=exercises;
		this.workoutPlan=workoutPlan;
	}

	public int getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}

	public String getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(String exerciseId) {
		this.exerciseId = exerciseId;
	}

	public Iterable<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(Iterable<Exercise> exercises) {
		this.exercises = exercises;
	}

	public WorkoutPlan getWorkoutPlan() {
		return workoutPlan;
	}

	public void setWorkoutPlan(WorkoutPlan workoutPlan) {
		this.workoutPlan = workoutPlan;
	}

	@Override
	public String toString() {
		return "AddWorkoutPlanItemForm [workoutId=" + workoutId + ", exerciseId=" + exerciseId + ", exercises="
				+ exercises + ", workoutPlan=" + workoutPlan + "]";
	}
}
