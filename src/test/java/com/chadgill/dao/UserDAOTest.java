package com.chadgill.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.chadgill.entity.User;
import com.chadgill.entity.WorkoutPlan;

@AutoConfigureTestDatabase(replace=Replace.NONE)
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserDAOTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserDAO userDao;
	
	@Before
	public void setUp() throws Exception{
		userDao.deleteAll();
	}
	
	@Test
	public void testSaveNewUser() throws Exception{
		User user = getUser();
		User savedInDb = entityManager.persist(user);
		Optional<User> findFromDb=userDao.findById(savedInDb.getId());
		User getFromDb = findFromDb.get();
		
		assertThat(getFromDb).isEqualTo(savedInDb);
	}
	
	private User getUser() {
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setEmail("JD@Email.com");
		user.setUserName("user");
		user.setPassWord("password");
		
		return user;
	}
	
	@Test
	public void testFindById() {
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setEmail("JD@Email.com");
		user.setUserName("user");
		user.setPassWord("password");
		
		User userSavedinDb = entityManager.persist(user);
		
		Optional<User> userFromDb = userDao.findById(userSavedinDb.getId());
		User getFromDb=userFromDb.get();
		assertThat(userSavedinDb).isEqualTo(getFromDb);
		
		
	}
	
	@Test
	public void testFindByUsernameAndPassword() {
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setEmail("JD@Email.com");
		user.setUserName("user");
		user.setPassWord("password");
		
		User userSavedinDb = entityManager.persist(user);
		
		//get user
		User userFromDb = userDao.findUserByUserNameAndPassWord(userSavedinDb.getUserName(), userSavedinDb.getPassWord());
		
	String getFromDb=userFromDb.getUserName()+user.getPassWord();
	assertThat(userSavedinDb.getUserName()+userSavedinDb.getPassWord()).isEqualTo(getFromDb);
	}
	
	@Test
	public void testGetAllUsers() {
		User user1 = new User();
		user1.setFirstName("John");
		user1.setLastName("Doe");
		user1.setEmail("JD@Email.com");
		user1.setUserName("user");
		user1.setPassWord("password");
		
		User user2 = new User();
		user2.setFirstName("Jane");
		user2.setLastName("Smith");
		user2.setEmail("JS@Email.com");
		user2.setUserName("JaneUser");
		user2.setPassWord("JanePassword");
		
		entityManager.persist(user1);
		entityManager.persist(user2);
		
		Iterable<User> allUsersFromDb=userDao.findAll();
		List<User> userList=new ArrayList<>();
		
		for(User user : allUsersFromDb) {
			userList.add(user);
		}
		assertThat(userList.size()).isEqualTo(2);
	}
}
