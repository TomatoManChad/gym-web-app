package com.chadgill.service;

import java.util.List;

import com.chadgill.entity.User;


public interface UserService {

	//public void saveNewUser(User user);
	public void saveNewUser(User user);

	public List<User> getAllUsers();
	
	public User findUserByUserNameAndPassWord(String userName, String passWord);
	
}
