package com.chadgill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chadgill.dao.UserDAO;
import com.chadgill.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO=userDAO;
	}
	
	@Override
	public void saveNewUser(User user) {
		userDAO.saveNewUser(user);
		
	}

	@Override
	public List<User> getUsers() {
		
		return userDAO.getUsers();
	}

	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
