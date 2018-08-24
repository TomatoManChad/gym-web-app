package com.chadgill.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.chadgill.dao.ExerciseDAO;
import com.chadgill.entity.Exercise;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ExerciseServiceTest {

	@TestConfiguration
	static class ExerciseServiceImplTestContextConfiguration{
		@Bean
		public ExerciseService exerciseService() {
			return new ExerciseServiceImpl();
		}
	}
	
	@Autowired
	private ExerciseService exerciseService;
	
	@MockBean
	private ExerciseDAO exerciseDao;
	
	@Before
	public void setUp() {
		Exercise exercise = new Exercise();
		exercise.setName("Squat");
		exercise.setInstructions("Instructions on how to squat");
		exercise.setVideo("youtube.com/squat");
		
		Mockito.when(exerciseDao.getExercise(exercise.getName())).thenReturn(exercise);
	}
	
	@Test
	public void testGetExercise() {
		String exerciseName="Squat";
		Exercise found=exerciseService.getExercise(exerciseName);
		assertThat(found.getName()).isEqualTo(exerciseName);
	}
	
	@Test
	public void testGetAllExercises() throws IOException {
		Exercise exercise1 = new Exercise();
		exercise1.setName("Squat");
		exercise1.setInstructions("Instructions on how to squat");
		exercise1.setVideo("youtube.com/squat");
		
		Exercise exercise2 = new Exercise();
		exercise2.setName("Leg Press");
		exercise2.setInstructions("Instructions on how to leg press");
		exercise2.setVideo("youtube.com/legpress");
		
		List<Exercise> exerciseList = new ArrayList<>();
		exerciseList.add(exercise1);
		exerciseList.add(exercise2);
		
		Mockito.when(exerciseDao.getAllExercises()).thenReturn(exerciseList);
		
		assertThat(exerciseService.getAllExercises()).isEqualTo(exerciseList);
		
	}
}
