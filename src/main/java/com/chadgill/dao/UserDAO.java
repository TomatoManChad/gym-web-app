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

	/**finds the user trying to login based on thier entered username and password credentials
	 * @param userName the name of user
	 * @param passWord password of user
	 * @return the user with assossiated username and password
	 */
	public User findUserByUserNameAndPassWord(String userName, String passWord);

	

	


	 

}
