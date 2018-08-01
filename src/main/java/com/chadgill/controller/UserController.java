package com.chadgill.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.chadgill.entity.User;
import com.chadgill.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	@GetMapping("/saveuser")
	public String saveUser(@RequestParam String userName, @RequestParam String firstName,@RequestParam String lastName, @RequestParam String email,@RequestParam String passWord ) {
		User user = new User(userName,firstName,lastName,email,passWord);
		userService.saveNewUser(user);
		System.out.println(user.toString());
		return "saved user";
	}
	
	@RequestMapping("/register")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}
	
	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		userService.saveNewUser(user);
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}
	
	@GetMapping("/show-users")
	public String showAllUsers(HttpServletRequest request) {
		request.setAttribute("users", userService.getUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "welcomepage";
	}
	
	//shows login stuff
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
	}
	
	@RequestMapping("/login-user")
	public String loginUser(@ModelAttribute User user,HttpServletRequest request) {
		if(userService.findUserByUsernameAndPassword(user.getUserName(), user.getPassWord()) != null){
			System.out.println(user.getUserName()+user.getPassWord());
			return "homepage";
		} else {
		request.setAttribute("error", "Invalid Username or Password");
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
		
		}
	}
/*public String listUsers(Model theModel) {
		
		List<User> theUsers = userService.getUsers();
		//add  to the model
		theModel.addAttribute("users", theUsers);
		return "welcomepage";	
}*/
	@RequestMapping("/message-user")
	public String messageUser(@RequestParam String email, HttpServletRequest request) {
		
		return "redirect:/show-users";
	}
}
