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
import com.chadgill.entity.MuscleGroup;
import com.chadgill.service.MuscleGroupService;

@Controller
@RequestMapping("/musclegroup")
public class MuscleGroupController {

	@Autowired
	private MuscleGroupService muscleGroupService;

	@GetMapping("/insertmusclegroups")
	public String saveMuscleGroup(@ModelAttribute("musclegroup") MuscleGroup theMuscleGroup) {
		// save the muscleGroup using service
		muscleGroupService.insert(theMuscleGroup);
		return "redirect:/workout_plan/list/";
	}

	/**
	 * retrieves all muscle groups from database through service layer
	 * 
	 * @param theModel adds all muscle groups to model attribute musclegroups
	 * @return the jsp page of muscle groups
	 * @throws IOException
	 */
	@GetMapping("/list")
	public String listAllMuscleGroups(@Valid Model theModel) throws IOException {

		List<MuscleGroup> theMuscleGroups = muscleGroupService.getAllMuscleGroups();
		// add MuscleGroups to the model
		theModel.addAttribute("musclegroups", theMuscleGroups);

		return "musclegroup-list";
	}

	/**
	 * retrieves the exercises of a specific muscle group and mapped to the muscle
	 * group id as pathvariable
	 * 
	 * @param theId    the specific id of muscle group retrieved
	 * @param theModel adds the muscle group description and exercises to model
	 *                 attribute
	 * @return the muscle-group-exercises jsp page
	 * @throws IOException
	 */
	@GetMapping("/list/{muscleid}")
	public String showexercises(@PathVariable("muscleid") String theId, Model theModel) throws IOException {

		MuscleGroup themusleGroup = muscleGroupService.getMuscleGroup(theId);
		theModel.addAttribute("muscleinfo", themusleGroup.getDescription());
		System.out.println(themusleGroup.getDescription());
		// populating muscleExercise attribute with exercises
		theModel.addAttribute("muscleExercises", themusleGroup.getExercises());

		return "muscle-group-exercises";
	}

}
