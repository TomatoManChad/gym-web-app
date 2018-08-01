package com.chadgill.service;

import java.util.List;

import com.chadgill.entity.User;

public interface UserService {

	public void saveNewUser(User user);

	public List<User> getUsers();
	
	public User findUserByUsernameAndPassword(String username, String password);

}
