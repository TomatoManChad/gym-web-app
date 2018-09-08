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
import org.springframework.ui.ModelMap;
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

	/**
	 * this method retrieves the current user session id and then displays the users
	 * workout plans and maps the url to be the user id
	 * 
	 * @param model  defines the attributes of title and users workouts to be
	 *               rendered in the view
	 * @param userid the current session user
	 * @return this returns the jsp page that displays users workouts
	 */
	@GetMapping("/{userid}")
	public String allWorkouts(Model model, @PathVariable("userid") int userid) {
		User theUser = userService.getCurrentUser(userid);
		System.out.println(theUser.getUserName());
		model.addAttribute("title", "WorkoutPlans");
		model.addAttribute("workoutPlans", theUser.getWorkoutPlans());
		System.out.println("USER WORKOUT: " + theUser.getWorkoutPlans());
		return "allworkouts";
	}

	/**
	 * creates a new workout plan
	 * 
	 * @param model the workout object is added to the model to be rendered in page
	 * @return the add jsp page to be returned
	 */
	@GetMapping("/add")
	public String add(Model model) {
		WorkoutPlan theWorkout = new WorkoutPlan();
		model.addAttribute("title", "Add WorkoutPlan");
		model.addAttribute("workout", theWorkout);
		return "add";
	}

	/**
	 * saves the workout plan to to the current user session
	 * 
	 * @param model
	 * @param workoutPlan the workout plan to be added to user
	 * @param userid      the current user session
	 * @return redirect back to this workout view jsp
	 */
	@PostMapping("/saveWorkout")
	public String saveWorkout(Model model, @ModelAttribute @Valid WorkoutPlan workoutPlan, @RequestParam int userid) {
		User theUser = userService.getCurrentUser(userid);
		theUser.add(workoutPlan);
		workoutPlanService.save(workoutPlan);
		return "redirect:/workout_plan/view/" + workoutPlan.getId();

	}

	/**
	 * this method will find the workout to be viewed
	 * 
	 * @param model     the attributes required for a workout
	 * @param workoutId the id of the specific workout to be viewed
	 * @return the view jsp and mapped to workout id
	 */
	@GetMapping("/view/{workoutId}")
	public String viewWorkout(Model model, @PathVariable int workoutId) {
		WorkoutPlan theWorkout = workoutPlanService.findById(workoutId).orElse(null);

		model.addAttribute("title", theWorkout.getName());
		model.addAttribute("exercises", theWorkout.getExercises());
		model.addAttribute("workoutId", theWorkout.getId());
		System.out.println("INSIDE VIEW WORKOUT EXERCISES: " + theWorkout.getExercises());

		return "view";

	}

	/**
	 * this method gets the specific workout id to add exercises to
	 * 
	 * @param model     the attributes of workout name and list of exercises of
	 *                  specific workout plan
	 * @param workoutId the specific workout plan
	 * @return the jsp page to add exercises
	 * @throws IOException
	 */
	@GetMapping("/add-item/{workoutId}")
	public String addItem(Model model, @PathVariable int workoutId) throws IOException {

		WorkoutPlan theWorkout = workoutPlanService.findById(workoutId).orElse(null);

		AddWorkoutPlanItemForm form = new AddWorkoutPlanItemForm(exerciseDAO.getAllExercises(), theWorkout);

		model.addAttribute("title", "Add exercise to workout: " + theWorkout.getName());
		model.addAttribute("form", form);
		System.out.println("INSIDE ADD ITEM GET: " + theWorkout.getName());
		return "add-item";
	}

	/**
	 * this method adds exercises to the specific workout plan
	 * 
	 * @param model  adds AddWorkoutPlanItemForm to model attribute
	 * @param form   the workout plan and list of exercises
	 * @param errors adds AddWorkoutPlanItemForm attribute to model if there is
	 *               error
	 * @return the specific view jsp for that workout plan
	 */
	@PostMapping("/add-item")
	public String addItem(Model model, @ModelAttribute AddWorkoutPlanItemForm form, Errors errors) {
		if (errors.hasErrors()) {
			model.addAttribute("form", form);
			return "add-item";
		}
		Exercise theExercise = exerciseDAO.getExercise(form.getExerciseId());
		WorkoutPlan theWorkout = workoutPlanService.findById(form.getWorkoutId()).orElse(null);
		theWorkout.addExercise(theExercise);
		System.out.println("inside addItem: " + theWorkout.getExercises());
		workoutPlanService.save(theWorkout);
		return "redirect:/workout_plan/view/" + theWorkout.getId();

	}

	/**
	 * deletes a workout
	 * 
	 * @param userid    the current user session id
	 * @param workoutId the specific workout id to be deleted
	 * @return redirects back to workout plan jsp of that user session
	 */
	@GetMapping("{userid}/delete/{workoutId}")
	public String deleteWorkout(@PathVariable("userid") int userid, @PathVariable("workoutId") int workoutId) {

		workoutPlanService.deleteById(workoutId);

		return "redirect:/workout_plan/" + userid;
	}
}
