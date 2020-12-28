package com.example.db;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.backendDB.pojo.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class StudentCTest {

	
	private MockMvc mvc;

	@Autowired
	public WebApplicationContext context;
	/*@InjectMocks
	private CountryController controller;
	@MockBean
	private StudentService service;
*/
	@Before
	public void setup() {
		
		mvc=MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void canRetrieveByIdWhenExists() throws Exception {
		// given
		Student st = new Student();
		st.setName("bharath");
		st.setPhone(123213212);
		st.setQual("Dev");
		// when(service.getStudentByid(1)).thenReturn(st);

		// when
		ResultActions response = mvc.perform(get("/student/1"));
		System.out.println(response.andReturn().getResponse().getStatus());
		System.out.println(response.andReturn().getResponse().getContentAsString());

	}

}
