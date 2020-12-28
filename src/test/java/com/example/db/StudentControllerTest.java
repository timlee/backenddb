/*package com.example.db;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.backendDB.controller.StudentController;
import com.example.backendDB.pojo.Student;
import com.example.backendDB.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(StudentController.class)
public class StudentControllerTest {


	 
	    private MockMvc mockMvc;
	   
	    @InjectMocks
	    private StudentService service;

	    @Before
	    public void setup() {
	        mockMvc = MockMvcBuilders.webAppContextSetup(context)
	                .build();
	    }

	    @Test
	    public void findObjects_StorageIsNotEmpty_OneObjectIsReturned() throws Exception {
	        given(service.findByName("Bharath")).willReturn(Arrays.asList(new Student()));
	        mockMvc
	                .perform(get("/api/v1/objects"))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
	                .andExpect(jsonPath("$", Matchers.hasSize(1)));
	    }


}
*/