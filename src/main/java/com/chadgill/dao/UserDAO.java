package com.chadgill.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chadgill.entity.User;

public interface UserDAO {

	void saveNewUser(User user);


	public List<User> getUsers();


	User findUserByUsernameAndPassword(String username, String password);

}
