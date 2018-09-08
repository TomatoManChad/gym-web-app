package com.chadgill.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.chadgill.dao.UserDAO;
import com.chadgill.entity.User;
import com.chadgill.service.UserService;
import com.chadgill.service.WorkoutPlanService;

@Controller
@SessionAttributes("userid")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private WorkoutPlanService workoutPlanService;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	/**the welcome method that sets attribute to welcome page when user initial enters website
	 * @param request set the mode of jsp page
	 * @return welcome page
	 */
	@RequestMapping("/")
	public String welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_WELCOME");
		return "welcomepage";
	}

	/**retrieve new user details to register and be saved
	 * @param userName the username
	 * @param firstName the firstname
	 * @param lastName the lastname
	 * @param email the email
	 * @param passWord the password
	 * @return
	 */
	@GetMapping("/saveuser")
	public String saveUser(@RequestParam String userName, @RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String email, @RequestParam String passWord) {
		User user = new User(userName, firstName, lastName, email, passWord);
		userService.saveNewUser(user);
		return "User saved";

	}

	/**the welcome page that sets attribute mode to register if registering is choosen
	 * @param request set the mode of jsp page
	 * @return the welcome page jsp
	 */
	@RequestMapping("/register")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}

	/**saves a new user to the database if validation is met
	 * @param user the user to be saved
	 * @param bindingResult
	 * @param request sets the jsp page mode depending on outcome of user validation
	 * @return returns jsp page welcomepage
	 */
	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {

		for (int i = 0; i < userService.getAllUsers().size(); i++) {
			if (user.getUserName().equals(userService.getAllUsers().get(i).getUserName())) {

				request.setAttribute("error", "Username already taken, please enter a different one");
				request.setAttribute("mode", "MODE_REGISTER");
				return "welcomepage";

			}
		}

		if (user.getUserName().trim().equals("") && user.getPassWord().trim().equals("")) {
			request.setAttribute("error", "Username & Password must not be empty");
			request.setAttribute("mode", "MODE_REGISTER");
			return "welcomepage";
		} else if (user.getUserName().trim().equals("")) {
			request.setAttribute("error", "Username must not be empty");
			request.setAttribute("mode", "MODE_REGISTER");
			return "welcomepage";
		} else if (!user.getUserName().matches("[\\w*\\s*]*")) {
			request.setAttribute("error", "Username can only contain letters and numbers");
			request.setAttribute("mode", "MODE_REGISTER");
			return "welcomepage";
		} else if (user.getPassWord().trim().equals("")) {
			request.setAttribute("error", "Password must not be empty");
			request.setAttribute("mode", "MODE_REGISTER");
			return "welcomepage";
		} else if (!user.getPassWord().matches("[\\w*\\s*]*")) {
			request.setAttribute("error", "Password can only contain letters and numbers");
			request.setAttribute("mode", "MODE_REGISTER");
			return "welcomepage";
		}
		else if(!user.getFirstName().matches("[a-zA-Z\\s*]*") ||!user.getLastName().matches("[a-zA-Z\\s*]*") ){
			request.setAttribute("error", "First Name and Last Name can only contain letters");
			request.setAttribute("mode", "MODE_REGISTER");
			return "welcomepage";
		}

		else {
			userService.saveNewUser(user);
			request.setAttribute("mode", "MODE_WELCOME");
			return "welcomepage";
		}
	}

	// shows login stuff
	/**the method to show login jsp
	 * @param request sets the attribute mode to login
	 * @return the welcomepage jsp
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
	}

	/**this method checks if login is successful or not
	 * @param user the user attempting login
	 * @param request sets the attribute depending on outcome
	 * @param session sets session to user
	 * @param model retrieves the username and user id
	 * @return returns homepage if successful, returns welcomepage if unsuccessful login
	 */
	@RequestMapping("/login-user")
	public String loginUser(@ModelAttribute User user, HttpServletRequest request, HttpSession session, ModelMap model) {
	user = userService.findUserByUserNameAndPassWord(user.getUserName(), user.getPassWord());
	
		if (user!= null) {
			model.put("userid", user.getId());
			model.put("username", user.getUserName());
			session.setAttribute("loggedInUser", user);
			return "homepage";

		} else {
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";
		}	
	}


	/**logout user by setting attribute back to welcome mode and page
	 * @param user the to be logged out
	 * @param request the attribute mode being set
	 * @return welcome page jsp
	 */
	@RequestMapping("/logout")
	public String logoutUser(@ModelAttribute User user, HttpServletRequest request) {
		request.setAttribute("mode", "MODE_WELCOME");
		return "welcomepage";
	}
}
