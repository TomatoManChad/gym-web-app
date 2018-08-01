package com.chadgill.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.chadgill.dao.ExerciseDAO;
import com.chadgill.entity.Exercise;

@Controller
@RequestMapping("/exercise")
public class ExerciseController {
	@Autowired
	private ExerciseDAO exerciseDAO;
	
	@GetMapping("/list")
	public String listAllExercises(Model theModel) throws IOException{
		List<Exercise> theexercises = exerciseDAO.getAllExercises();
		theModel.addAttribute("exercises", theexercises);
		return "list-exercises";
	}
	
	@GetMapping("/delete")
	public String deleteExercise(@RequestParam("exercise") int theId) {
		//delete customer
		exerciseDAO.deleteExercise(theId);
		return "redirect:/workout_plan/list";
	}
	
	@GetMapping("/{id}")
	public String showExerciseInfo(@PathVariable("id") int theId, @Valid Model theModel,@ModelAttribute("exercise") Exercise theExercise1, BindingResult theBindingResult) { //need to change exercise id pk to become exercisename in future
		
		//get customer from service
		Exercise theExercise = exerciseDAO.getExercise(theId);
		
		//set customer as a model attribute to pre-populate the form
		theModel.addAttribute("exercise", theExercise);// "exercise" is linked to jsp page...${exercise.instructions
		System.out.println("test"+ theExercise.toString());
		System.out.println("test1 "+ theBindingResult);
		//send over to form
		
		return "exercise-info";
	}
}
