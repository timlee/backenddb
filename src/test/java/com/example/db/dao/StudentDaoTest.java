package com.example.db.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.backendDB.dao.StudentDao;
import com.example.backendDB.pojo.Student;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentDaoTest {

	@Autowired
	private StudentDao dao;
	
	
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
		dao.save(st);
		dao.save(st2);
	}
	@Test
	public void verifyByQualTest() {
		List<Student> listOfStudents = dao.findByQual("SoftwareDeveloper");
		System.out.println(listOfStudents.size());
		Assert.assertEquals(1,listOfStudents.size());
	}
	
	@Test
	public void verifyByNameTest() {
		List<Student> listOfStudents = dao.findByName("Bharath");
		System.out.println(listOfStudents.size());
		Assert.assertEquals(2,listOfStudents.size());
	}
	@Test
	public void verifyByStdTest() {
		List<Student> listOfStudents = dao.getStd("Bharath");
		System.out.println(listOfStudents.size());
		Assert.assertEquals(2,listOfStudents.size());
	}
}
