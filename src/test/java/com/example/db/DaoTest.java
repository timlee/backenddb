package com.example.db;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.backendDB.dao.StudentDao;
import com.example.backendDB.pojo.Student;

@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
public class DaoTest{

	/*	@Autowired
		TestEntityManager entityManager;
*/
	 	@Autowired
	    private StudentDao repository;

	    @Test
	    public void repositorySavesPerson() {
	    	Student person = new Student();
	        person.setName("Bharath1");
	        person.setId(23);
	        person.setPhone(123123123);
	        person.setQual(null);
	    	Student person1 = new Student();
	        person1.setName("Bharath2");
	        person1.setId(23);
	        person1.setPhone(123123123);
	        person1.setQual(null);
	        repository.save(person);
	        repository.save(person1);
	       
	       List<Student> stList =  repository.findAll();
	       System.out.println(stList.size());
	       Assert.assertEquals(2, stList.size());
	    } 

}
