/*package com.example.db;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.backendDB.dao.StudentDao;
import com.example.backendDB.pojo.Student;
import com.example.backendDB.service.StudentService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ServiceTest {

	@Autowired
	private StudentService service;

	@Autowired
	private TestEntityManager testEntityManager;

	
	//@Test
	public void contains_NotValidId_Success() {
		Student person = new Student();
        person.setName("Bharath1");
        person.setId(23);
        person.setPhone(123123123);
        person.setQual(null);
        
    	Student person1 = new Student();
        person1.setName("Bharath2");
        person1.setPhone(123123123);
        person1.setQual(null);
		testEntityManager.merge(person);
		testEntityManager.merge(person1);
		Student isContains = service.getStudentByid(2);
		Assert.assertNotNull( isContains);
	}

}
*/