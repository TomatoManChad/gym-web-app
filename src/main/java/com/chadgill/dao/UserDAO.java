package com.chadgill.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chadgill.entity.User;


@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

	
	//public void saveNewUser(User user); this breaks everything stuff DONT uncomment

	//public List<User> getUsers(); still dont need


	public User findUserByUserNameAndPassWord(String userName, String passWord);

	

	


	 

}
