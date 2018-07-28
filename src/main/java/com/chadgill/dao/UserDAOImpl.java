package com.chadgill.dao;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chadgill.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private EntityManager entityManager;

	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	
	@Override
	public void saveNewUser(User user) {
		Session currentSession = getSession();
		currentSession.save(user);
	}
}
