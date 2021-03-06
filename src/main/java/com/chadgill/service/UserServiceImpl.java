package com.chadgill.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chadgill.dao.UserDAO;
import com.chadgill.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO=userDAO;
	}
	

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		for(User user: userDAO.findAll()) {
			users.add(user);
		}
		return users;
	}

	@Override
	public User findUserByUserNameAndPassWord(String userName, String passWord) {
		
		return userDAO.findUserByUserNameAndPassWord(userName, passWord);
	}
	
	@Override
	public User saveNewUser(User user) {
		//user.setPassWord(bCryptPasswordEncoder.encode(user.getPassWord()));
		return userDAO.save(user);
	}


	@Override
	public User getCurrentUser(int userId) {
		return userDAO.findById(userId).get();
		
	}


	


}
