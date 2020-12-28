package com.example.db;


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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.backendDB.controller.HelloController;
import com.jayway.jsonpath.JsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
public class HelloTest {
	
	@InjectMocks
	private HelloController helloc;
	
	private MockMvc mockmvc;
	
	@Before
	public void setup()
	{
		mockmvc=MockMvcBuilders.standaloneSetup(helloc).build();
	}

	/*@Test
	public void test() throws Exception
	{

MockHttpServletRequestBuilder getobj=MockMvcRequestBuilders.get("/hello");
ResultActions rs=mockmvc.perform(getobj);
System.out.println(rs.andReturn().getResponse().getStatus());
System.out.println(rs.andReturn().getResponse().getContentAsString());
Assert.assertEquals(200, rs.andReturn().getResponse().getStatus());
Assert.assertEquals("welcome batch19!", rs.andReturn().getResponse().getContentAsString());

	}*/

	@Test
	public void test2() throws Exception
	{
		mockmvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string("welcome batch19!"));
		
	}
	@Test
	public void tets3() throws Exception
	{
		mockmvc.perform(get("/hello/json"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name",Matchers.is("mamatha")));
	}
	@Test
	public void tets4() throws Exception
	{
		mockmvc.perform(get("/hello/jsonList"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].name",Matchers.is("mamatha1")));
	}
}
