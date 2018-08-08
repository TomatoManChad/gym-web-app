package com.chadgill.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chadgill.dao.MuscleGroupDAO;
import com.chadgill.entity.Exercise;
import com.chadgill.entity.MuscleGroup;

@Controller
@RequestMapping("/musclegroup")
public class MuscleGroupController {
	@Autowired
	private MuscleGroupDAO muscleGroupDAO;
	
	@GetMapping("/insertmusclegroups")
	public String saveMuscleGroup(@ModelAttribute("musclegroup") MuscleGroup theMuscleGroup) {
		//save the muscleGroup using  service
		muscleGroupDAO.insert(theMuscleGroup);
		return "redirect:/workout_plan/list/";
	}
	
	@GetMapping("/list")
	public String listAllMuscleGroups(@Valid Model theModel) throws IOException{
		
		//get MuscleGroups from the dao... changed
		List<MuscleGroup> theMuscleGroups = muscleGroupDAO.getAllMuscleGroups();
		//add MuscleGroups to the model
		theModel.addAttribute("musclegroups", theMuscleGroups);
		
		//currently not made. just takes you to workout_plan page
		return "musclegroup-list";
	}
	
	@GetMapping("/list/{muscleid}")
	public String showexercises(@PathVariable("muscleid") String theId, Model theModel) throws IOException {
		
		MuscleGroup themusleGroup = muscleGroupDAO.getMuscleGroup(theId);
		theModel.addAttribute("muscleinfo",themusleGroup.getDescription());
		System.out.println(themusleGroup.getDescription());
		//populating muscleExercise attribute with exercises
		theModel.addAttribute("muscleExercises", themusleGroup.getExercises());
		//System.out.println("NEWTEST: " + themusleGroup.getExercises());
		
		return "muscle-group-exercises";
	}

}
