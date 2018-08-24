package com.chadgill.service;

import java.util.List;

import com.chadgill.entity.User;


public interface UserService {

	public User saveNewUser(User user);

	public List<User> getAllUsers();
	
	public User findUserByUserNameAndPassWord(String userName, String passWord);
	
}
