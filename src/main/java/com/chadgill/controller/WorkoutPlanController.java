package com.chadgill.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chadgill.dao.ExerciseDAO;
import com.chadgill.entity.Exercise;
import com.chadgill.entity.WorkoutPlan;
import com.chadgill.service.WorkoutPlanService;

@Controller
@RequestMapping("/workout_plan")
public class WorkoutPlanController {

//	@Autowired
//	private WorkoutPlanDAO workoutplanDAO;
	@Autowired
	private WorkoutPlanService workoutPlanService;
	
	@Autowired
	private ExerciseDAO exerciseDAO;
	
	//@RequestMapping("/list")
	@GetMapping("/list")
	public String listWorkouts(Model theModel) {
		List<WorkoutPlan> workoutplans = workoutPlanService.getWorkoutPlans();
		theModel.addAttribute("workouts", workoutplans);
		return "workout-list";
	}
/*	@GetMapping("/addExercise") 
	public String listAllExercisesForInsertToWorkout(Model theModel) throws IOException{
		List<Exercise> theexercises = exerciseDAO.getAllExercises();
		theModel.addAttribute("exercises", theexercises);
		return "workout-form";
	}*/
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) throws IOException {
		//create model attribute to bind form data
		WorkoutPlan theWorkoutPlan = new WorkoutPlan();
		theModel.addAttribute("workout", theWorkoutPlan);
		
		
		List<Exercise> theexercises = exerciseDAO.getAllExercises();
		theModel.addAttribute("exercises", theexercises);
		
		
		
		return "workout-form";
	}
	
	@PostMapping("/saveWorkoutPlan")
	public String saveWorkoutPlan(@ModelAttribute("workout") WorkoutPlan theWorkoutPlan) {
		workoutPlanService.saveWorkoutPlan(theWorkoutPlan);
		
		return "redirect:/workout_plan/list";
	}
	
	@GetMapping("/delete")
	public String deleteWorkout(@RequestParam("workout") int theId) {
		workoutPlanService.deleteWorkout(theId);
		return "redirect:/workout_plan/list";
	}
	
/*	@PostMapping("/saveWorkoutPlan")
	public String addExerciseToWorkout(@RequestParam("exercise") int theExercise) { 
		workoutPlanService.saveExercise(theExercise);
	return "redirect:/workout_plan/list";
	}*/
	
}
