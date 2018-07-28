package com.chadgill.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
