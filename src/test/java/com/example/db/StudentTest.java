/*package com.example.db;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.backendDB.controller.HelloController;
import com.example.backendDB.controller.StudentController;
import com.example.backendDB.service.StudentService;
import com.jayway.jsonpath.JsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
public class StudentTest {
	
	@InjectMocks
	private StudentController stc;
	
	private MockMvc mockmvc;
	
	@Before
	public void setup()
	{
		mockmvc=MockMvcBuilders.standaloneSetup(stc).build();
	}

	@InjectMocks
	private StudentService studentservice;
	

	@Test
	public void test2() throws Exception
	{
		String st = mockmvc.perform(get("/student/1")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		System.out.println(st);
	}
	@Test
	public void tets3() throws Exception
	{
		mockmvc.perform(get("/hello/jsonList"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name",Matchers.is("mamatha")));


	}
	
}
*/