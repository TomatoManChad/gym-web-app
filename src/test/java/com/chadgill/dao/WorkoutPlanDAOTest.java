package com.chadgill.dao;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
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

import com.chadgill.entity.WorkoutPlan;

@AutoConfigureTestDatabase(replace=Replace.NONE)
@RunWith(SpringRunner.class)
@DataJpaTest
public class WorkoutPlanDAOTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private WorkoutPlanDAO workoutPlanDao;
	
	
	@Before
	public void setUp() throws Exception{
		workoutPlanDao.deleteAll();
	}
	
	@Test
	public void testSave() {
		WorkoutPlan workout = getWorkout();
		WorkoutPlan savedInDb =entityManager.persist(workout);
		Optional<WorkoutPlan> findFromDb=workoutPlanDao.findById(savedInDb.getId());
		WorkoutPlan getFromDb = findFromDb.get();
		
		assertThat(getFromDb).isEqualTo(savedInDb);
		//assertEquals(getFromDb, savedInDb);
	}
	
	private WorkoutPlan getWorkout() {
		WorkoutPlan workout = new WorkoutPlan();
		workout.setName("Monday Workout");
		return workout;
	}
	
	@Test
	public void testFindById() {
		WorkoutPlan workout = new WorkoutPlan();
		workout.setName("Chest workout");
		
		WorkoutPlan workoutSavedInDb= entityManager.persist(workout);
		
		//get workout
		Optional<WorkoutPlan>  workoutFromDb= workoutPlanDao.findById(workoutSavedInDb.getId());
		WorkoutPlan getFromDb = workoutFromDb.get();
		
		assertThat(workoutSavedInDb).isEqualTo(getFromDb);
		//assertEquals(workoutSavedInDb, getFromDb);
	}
	
	@Test
	public void testFindAll() {
		WorkoutPlan tuesdayWorkout = new WorkoutPlan();
		tuesdayWorkout.setName("Tuesday Workout");
		
		WorkoutPlan wednesdayWorkout = new WorkoutPlan();
		wednesdayWorkout.setName("Wednesday Workout");
		
		entityManager.persist(tuesdayWorkout);
		entityManager.persist(wednesdayWorkout);
		
		Iterable<WorkoutPlan> allWorkoutsFromDb = workoutPlanDao.findAll();
		List<WorkoutPlan> workoutPlanList= new ArrayList<>();
		
		
		for (WorkoutPlan workout : allWorkoutsFromDb) {
			workoutPlanList.add(workout);
		}
		assertThat(workoutPlanList.size()).isEqualTo(2);
		//assertEquals(workoutPlanList.size(), 2);
		
		
	}
	
	@Test
	public void testDeleteById() {
		WorkoutPlan tuesdayWorkout = new WorkoutPlan();
		tuesdayWorkout.setName("Tuesday Workout");
		
		WorkoutPlan wednesdayWorkout = new WorkoutPlan();
		wednesdayWorkout.setName("Wednesday Workout");
		
		//saving to db
		WorkoutPlan persist = entityManager.persist(tuesdayWorkout);
		entityManager.persist(wednesdayWorkout);
		
		//remove one from db
		entityManager.remove(persist);
		
		Iterable<WorkoutPlan> allWorkoutsFromDb = workoutPlanDao.findAll();
		List<WorkoutPlan> workoutPlanList= new ArrayList<>();
		
		for (WorkoutPlan workout : allWorkoutsFromDb) {
			workoutPlanList.add(workout);
		}
		assertThat(workoutPlanList.size()).isEqualTo(1);
		//assertEquals(workoutPlanList.size(), 1);
	}
}
