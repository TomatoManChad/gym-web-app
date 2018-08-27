package com.chadgill.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chadgill.dao.UserDAO;
import com.chadgill.entity.User;
import com.chadgill.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDAO userDao;

	@RequestMapping("/")
	public String welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_WELCOME");
		return "welcomepage";
	}

	@GetMapping("/saveuser")
	public String saveUser(@RequestParam String userName, @RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String email, @RequestParam String passWord) {
		User user = new User(userName, firstName, lastName, email, passWord);
		userService.saveNewUser(user);
		return "User saved";

	}

	@RequestMapping("/register")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}

	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		/*userService.saveNewUser(user);
		request.setAttribute("mode", "MODE_WELCOME");
		return "welcomepage";*/
	
	
		//if (!user.getUserName().trim().equals("") && !user.getPassWord().trim().equals("")) {
		/*	userService.saveNewUser(user);
			request.setAttribute("mode", "MODE_WELCOME");
			return "welcomepage";
			}*/
		if (user.getUserName().trim().equals("") && user.getPassWord().trim().equals("") ){
				request.setAttribute("error", "Username & Password must not be empty");
				request.setAttribute("mode", "MODE_REGISTER");
				return "welcomepage";} 
	else if(user.getUserName().trim().equals("")){
				request.setAttribute("error", "Username must not be empty");
				request.setAttribute("mode", "MODE_REGISTER");
				return "welcomepage";
			}
			else if (user.getPassWord().trim().equals("")){
				request.setAttribute("error", "Password must not be empty");
				request.setAttribute("mode", "MODE_REGISTER");
				return "welcomepage";
				}
			else { 
				userService.saveNewUser(user);
			request.setAttribute("mode", "MODE_WELCOME");
			return "welcomepage";}
	}

/*	@GetMapping("/show-users")
	public String showAllUsers(HttpServletRequest request) {
		request.setAttribute("users", userService.getAllUsers());
		request.setAttribute("mode", "ALL_USERS");

		return "homepage";
	}*/

	

	// shows login stuff
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
	}

	@RequestMapping("/login-user")
	public String loginUser(@ModelAttribute User user, HttpServletRequest request) {

		if (userService.findUserByUserNameAndPassWord(user.getUserName(), user.getPassWord()) != null) {
			
			System.out.println(user.getUserName() + user.getPassWord());
			
			 for (int i=0; i<userService.getAllUsers().size();i++) {
		        	if (user.getUserName().equals(userService.getAllUsers().get(i).getUserName())) {
		        	System.out.println("TEST: "+userService.getAllUsers().get(i).getUserName());
		
		        			System.out.println(userService.getAllUsers().get(i).getId());
		        }
			 }
			return "homepage";

		} else {
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";

		}
	}

	@RequestMapping("/logout")
	public String logoutUser(@ModelAttribute User user, HttpServletRequest request) {
		request.setAttribute("mode", "MODE_WELCOME");
		return "welcomepage";
	}

	@RequestMapping("/message-user")
	public String messageUser(@RequestParam String email, HttpServletRequest request) {

		return "redirect:/show-users";
	}
}
