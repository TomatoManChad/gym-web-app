package com.chadgill.dao;

import org.springframework.data.repository.CrudRepository;

import com.chadgill.entity.User;

public interface UserDAO {

	void saveNewUser(User user);

}
