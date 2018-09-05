package com.chadgill.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.chadgill.dao.ExerciseDAO;
import com.chadgill.dao.UserDAO;
import com.chadgill.dao.WorkoutPlanDAO;
import com.chadgill.entity.AddWorkoutPlanItemForm;
import com.chadgill.entity.Exercise;
import com.chadgill.entity.User;
import com.chadgill.entity.WorkoutPlan;
import com.chadgill.service.UserService;
import com.chadgill.service.WorkoutPlanService;

@Controller
@SessionAttributes("userid")
@RequestMapping("/workout_plan")
public class WorkoutPlanController {

	@Autowired
	private WorkoutPlanService workoutPlanService;

	@Autowired
	private ExerciseDAO exerciseDAO;

	@Autowired
	private UserService userService;

	@GetMapping("/{userid}")
	public String allWorkouts(Model model, @PathVariable("userid") int userid) {
		User theUser = userService.getCurrentUser(userid);
		System.out.println(theUser.getUserName());
		model.addAttribute("title", "WorkoutPlans");
		model.addAttribute("workoutPlans", theUser.getWorkoutPlans());
		System.out.println("USER WORKOUT: " + theUser.getWorkoutPlans());
		return "allworkouts";
	}

	@GetMapping("/add")
	public String add(Model model) {
		WorkoutPlan theWorkout = new WorkoutPlan();
		model.addAttribute("title", "Add WorkoutPlan");
		model.addAttribute("workout", theWorkout);
		return "add";
	}

	@PostMapping("/saveWorkout")
	public String saveWorkout(Model model, @ModelAttribute @Valid WorkoutPlan workoutPlan, @RequestParam int userid) {
		User theUser = userService.getCurrentUser(userid);
		theUser.add(workoutPlan);
		workoutPlanService.save(workoutPlan);
		return "redirect:/workout_plan/view/" + workoutPlan.getId();

	}

	@GetMapping("/view/{workoutId}")
	public String viewWorkout(Model model, @PathVariable int workoutId) {
		WorkoutPlan theWorkout = workoutPlanService.findById(workoutId).orElse(null);

		model.addAttribute("title", theWorkout.getName());
		model.addAttribute("exercises", theWorkout.getExercises());
		model.addAttribute("workoutId", theWorkout.getId());
		System.out.println("INSIDE VIEW WORKOUT EXERCISES: " + theWorkout.getExercises());

		return "view";

	}

	@GetMapping("/add-item/{workoutId}")
	public String addItem(Model model, @PathVariable int workoutId) throws IOException {

		WorkoutPlan theWorkout = workoutPlanService.findById(workoutId).orElse(null);

		AddWorkoutPlanItemForm form = new AddWorkoutPlanItemForm(exerciseDAO.getAllExercises(), theWorkout);

		model.addAttribute("title", "Add exercise to workout: " + theWorkout.getName());
		model.addAttribute("form", form);
		System.out.println("INSIDE ADD ITEM GET: " + theWorkout.getName());
		return "add-item";
	}

	@PostMapping("/add-item")
	public String addItem(Model model, @ModelAttribute AddWorkoutPlanItemForm form, Errors errors) {
		System.out.println("TEST INSIDE METHOD ADD ITEM WHEN CLICKED" + form.toString());
		if (errors.hasErrors()) {
			System.out.println("INSIDE ERROR");
			model.addAttribute("form", form);
			return "add-item";
		}
		Exercise theExercise = exerciseDAO.getExercise(form.getExerciseId());// problem is form.getExerciseId returns
																				// null instead of actual value
		WorkoutPlan theWorkout = workoutPlanService.findById(form.getWorkoutId()).orElse(null);
		theWorkout.addExercise(theExercise);
		System.out.println("inside addItem: " + theWorkout.getExercises());
		workoutPlanService.save(theWorkout);
		return "redirect:/workout_plan/view/" + theWorkout.getId();

	}

	@GetMapping("/delete/{workoutId}")
	public String deleteWorkout(@PathVariable int workoutId) {

		workoutPlanService.deleteById(workoutId);
		return "allworkouts";
	}
}
