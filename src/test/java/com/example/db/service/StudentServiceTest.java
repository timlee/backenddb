package com.example.db.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.backendDB.pojo.Student;
import com.example.backendDB.service.StudentService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentServiceTest {

	@Autowired
	private StudentService service;
	
	@Autowired
	private TestEntityManager manager;
	
	@Before
	public void insertData() {
		Student st = new Student();
		st.setName("Bharath");
		st.setPhone(1231231231);
		st.setQual("SoftwareDeveloper");
		
		Student st2 = new Student();
		st2.setName("Bharath");
		st2.setPhone(1231231231);
		st2.setQual("SoftwareQA");
		
		
		//Data insertion which is required to testcase
		manager.merge(st);
		manager.merge(st2);
	}
	
	@Test
	public void testStudentService() {
		List<Student> stList= service.getStudents();
		System.out.println(stList.size());
		Assert.assertEquals(2, stList.size());
	}
	
	@Test
	public void testgetStudent() {
		Student stList= service.getStudentByid(1);
		System.out.println(stList);
	}
	
	@Test
	public void testgetStudentNull() {
		Student stList= service.getStudentByid(3);
		System.out.println(stList);
	}
	
	
	@Test
	public void callMessge() {
		
		service.verifyMessage();
	}
}
