package com.chadgill.controller;

import java.io.IOException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import com.chadgill.service.ExerciseService;

@Controller
@RequestMapping("/exercise")
public class ExerciseController {

	@Autowired
	private ExerciseService exerciseService;

	
	@GetMapping(value="/list",produces=MediaType.APPLICATION_JSON_VALUE)
	public String listAllExercises(Model theModel) throws IOException {
		List<Exercise> theexercises = exerciseService.getAllExercises();
		theModel.addAttribute("exercises", theexercises);
		return "list-exercises";
	}

	
	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public String showExerciseInfo(@PathVariable("id") String theId, @Valid Model theModel,
			@ModelAttribute("exercise") Exercise theExercise1, BindingResult theBindingResult) {

		// get exercise from service
		Exercise theExercise = exerciseService.getExercise(theId);

		
		theModel.addAttribute("exercise", theExercise);// "exercise" is linked to jsp page...${exercise.instructions
		System.out.println("test" + theExercise.toString());
		System.out.println("test1 " + theBindingResult);
	
		return "exercise-info";
	}
}
