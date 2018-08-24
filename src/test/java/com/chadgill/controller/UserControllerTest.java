package com.chadgill.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.assertj.core.api.Assertions.assertThat;
import com.chadgill.entity.User;
import com.chadgill.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@RunWith(SpringRunner.class)
//@WebMvcTest(value=UserController.class,secure = false)
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@Test
	public void addUsertest() throws Exception {
	User newUser = new User();
	newUser.setId(1);
	newUser.setUserName("user");
	newUser.setFirstName("John");
	newUser.setLastName("Doe");
	newUser.setEmail("JohnDoe@gmail.com");
	newUser.setPassWord("password");
	
	
	
	String URI = "/save-user";
	
	mockMvc.perform(post(URI)
			.contentType(MediaType.APPLICATION_JSON)
			.content(mapToJson(newUser)))
			.andExpect(status().isOk());
	
	}

	/*@Test
	public void testSaveUser() throws Exception {
		User mockUser = new User();
		//mockUser.setId(1);
		mockUser.setUserName("user");
		mockUser.setFirstName("John");
		mockUser.setLastName("Doe");
		mockUser.setEmail("JohnDoe@gmail.com");
		mockUser.setPassWord("password");
		
		String inputInJson = this.mapToJson(mockUser);
		
		String URI = "/save-user";
		
		Mockito.when(
				userService.saveNewUser(Mockito.any(User.class))).thenReturn(mockUser);

		Mockito.doReturn(mockUser)
	       .when(userService)
	       .saveNewUser(Mockito.any(User.class));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}*/
	
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
