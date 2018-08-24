package com.chadgill.controller;

import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.chadgill.dao.ExerciseDAO;
import com.chadgill.dao.MuscleGroupDAO;
import com.chadgill.entity.Exercise;
import com.chadgill.entity.MuscleGroup;
import com.chadgill.service.ExerciseService;
import com.chadgill.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/*@RunWith(SpringRunner.class)
@WebMvcTest(value=ExerciseController.class,secure = false)
public class ExerciseControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ExerciseService exerciseService;
	
	@Test
	public void testshowexerciseInfo() throws Exception {
		Exercise mockExercise1 = new Exercise();
		mockExercise1.setName("Squat");
		mockExercise1.setInstructions("Squat instructions here");
		mockExercise1.setVideo("www.youtube.com/squatlink");
	
		Mockito.when(exerciseService.getExercise(Mockito.anyString())).thenReturn(mockExercise1);
		String URI = "/exercise/Squat";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(mockExercise1);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}*/

/*	@Test
	public void testlistAllExercises() throws Exception {
		
		Exercise mockExercise1 = new Exercise();
		mockExercise1.setName("Squat");
		mockExercise1.setInstructions("Squat instructions here");
		mockExercise1.setVideo("www.youtube.com/squatlink");
		
	
		Exercise mockExercise2 = new Exercise();
		mockExercise2.setName("Bench Press");
		mockExercise2.setInstructions("Bench Press instructions here");
		mockExercise2.setVideo("www.youtube.com/BenchPress");
		
		
		
		
		List<Exercise> exerciseList = new ArrayList<>();
		exerciseList.add(mockExercise1);
		exerciseList.add(mockExercise2);
		
		Mockito.when(exerciseService.getAllExercises()).thenReturn(exerciseList);
	
		String URI = "/exercise/list";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(
				MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expectedJson = this.mapToJson(exerciseList);
		
		String outputInJson = result.getResponse().getContentAsString();
		
		assertThat(outputInJson).isEqualTo(expectedJson);
	
		//assertEquals(outputInJson, expectedJson);			
	}*/
	
	
/*	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}*/




