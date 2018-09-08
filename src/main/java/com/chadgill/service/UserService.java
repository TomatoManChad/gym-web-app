package com.chadgill.service;

import java.util.List;
import java.util.Optional;

import com.chadgill.entity.User;


public interface UserService {

	/**saves a new user to the database that has registered to the website
	 * @param user the user object created to be saved
	 * @return the user database to save user
	 */
	public User saveNewUser(User user);

	/**This method allows the retrieval of all users within the database
	 * @return a list of all users
	 */
	public List<User> getAllUsers();
	
	/**This method is used to login user based on valid credentials
	 * @param userName the entered username
	 * @param passWord the entered password
	 * @return the user from database is retrieved if found
	 */
	public User findUserByUserNameAndPassWord(String userName, String passWord);
	
	/**this method is used to get a user id once user currently logged in
	 * @param id the id of user
	 * @return find user by id arguments
	 */
	public User getCurrentUser(int id);

	

	
}
