package com.chadgill.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;
import com.chadgill.dao.MuscleGroupDAO;
import com.chadgill.entity.MuscleGroup;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MuscleGroupServiceTest {

	@TestConfiguration
	static class MuscleGroupServiceImplTestContextConfiguration {

		@Bean
		public MuscleGroupService muscleGroupService() {
			return new MuscleGroupServiceImpl();
		}
	}

	@Autowired
	private MuscleGroupService muscleGroupService;

	@MockBean
	private MuscleGroupDAO muscleGroupDao;

	@Before
	public void setUp() {
		MuscleGroup muscleGroup = new MuscleGroup("Chest", "The muscle family consisting within the pectoral region");

		Mockito.when(muscleGroupDao.getMuscleGroup(muscleGroup.getName())).thenReturn(muscleGroup);

	}

	@Test
	public void testGetMuscleGroup() {
		
		String muscleGroupName = "Chest";
		MuscleGroup found = muscleGroupService.getMuscleGroup(muscleGroupName);
		assertEquals(found.getName(), muscleGroupName);
	}
	
	@Test
	public void testGetAllMuscleGroups() throws IOException {
		MuscleGroup muscleGroup1 = new MuscleGroup();
		muscleGroup1.setName("Legs");
		muscleGroup1.setDescription("The lower body muscles");
		
		MuscleGroup muscleGroup2 = new MuscleGroup();
		muscleGroup2.setName("Biceps");
		muscleGroup2.setDescription("the upper arms");
		
		List<MuscleGroup> muscleList = new ArrayList<>();
		muscleList.add(muscleGroup1);
		muscleList.add(muscleGroup2);
		
		Mockito.when(muscleGroupDao.getAllMuscleGroups()).thenReturn(muscleList);
		
		assertEquals(muscleGroupService.getAllMuscleGroups(),muscleList);
	}
}
