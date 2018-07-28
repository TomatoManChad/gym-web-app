package com.chadgill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chadgill.entity.User;
import com.chadgill.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	
	
	@RequestMapping("/")
	public String welcome( ) {
		return "this is homepage";
	}
	
	@GetMapping("/save-user")
	public String saveUser(@RequestParam String userName, @RequestParam String firstName,@RequestParam String lastName, @RequestParam String email,@RequestParam String passWord ) {
		User user = new User(userName,firstName,lastName,email,passWord);
		userService.saveNewUser(user);
		System.out.println(user.toString());
		return "saved user";
		
	}
}
