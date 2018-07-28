package com.chadgill.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.chadgill.dao.MuscleGroupDAO;
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
	public String listAllMuscleGroups(Model theModel){
		
		//get MuscleGroups from the dao... changed
		List<MuscleGroup> theMuscleGroups = muscleGroupDAO.getAllMuscleGroups();
		//add MuscleGroups to the model
		theModel.addAttribute("musclegroups", theMuscleGroups);
		
		//currently not made. just takes you to workout_plan page
		return "redirect:/workout_plan/list/";
	}
}
