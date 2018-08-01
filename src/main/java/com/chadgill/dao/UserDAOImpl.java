package com.chadgill.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
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

	@Override
	public List<User> getUsers() {
		Session currentSession = getSession();

		Query<User> theQuery = currentSession.createQuery("from User order by lastName", User.class);

		List<User> users = theQuery.getResultList();

		return users;
	}

	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
