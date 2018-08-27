package com.chadgill.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Size(min = 1, message = "username must not be empty")
	@Column(name = "user_name", unique = true)
	private String userName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@NotNull
	@Size(min = 1, message = "password must not be empty")
	@Column(name = "password")
	private String passWord;

	@OneToMany(mappedBy = "user", 
			cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<WorkoutPlan> workoutPlans;

	public User() {

	};

	public User(String userName, String firstName, String lastName, String email, String passWord) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passWord = passWord;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public List<WorkoutPlan> getWorkoutPlans() {
		return workoutPlans;
	}

	public void setWorkoutPlans(List<WorkoutPlan> workoutPlans) {
		this.workoutPlans = workoutPlans;
	}
	
	
	public void add(WorkoutPlan tempWorkout) {
		if (workoutPlans == null) {
			workoutPlans = new ArrayList<>();
		}
		workoutPlans.add(tempWorkout);
		tempWorkout.setUser(this);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", passWord=" + passWord + "]";
	}
}
