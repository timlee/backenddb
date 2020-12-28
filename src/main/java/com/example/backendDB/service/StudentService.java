package com.example.backendDB.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.backendDB.dao.StudentDao;
import com.example.backendDB.pojo.Student;

@Service
public class StudentService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);
	
	@Autowired
	private StudentDao studentdao;
	
	@Transactional
	public void saveStudent(Student student)
	{
		LOGGER.trace("Control is in save Student service");
		studentdao.save(student);
	}
	
	@Transactional
	public void updateStudent(Student student)
	{
		studentdao.save(student);
	}
	
	@Transactional
	public void deleteStudent(Student student)
	{
		studentdao.delete(student);
	}

	
	public Student getStudentByid(Integer id)
	{
		 Optional<Student> option=studentdao.findById(id);
		 if(!option.isPresent()) {
			 return null;
		 }
		 System.out.println();
		 return option.get();
		
	}
	
	public List<Student> getStudents(Integer pageno,Integer pagesize)
	{
		Page<Student> page=studentdao.findAll(new PageRequest(pageno,pagesize));
		return page.getContent();
	}
	
	
   public List<Student> getStd(String name)
   {
	   return studentdao.getStd(name);
   }
	
	public   List<Student> findByName(String name)
	{
		return studentdao.findByName(name);
		
	}
   
   //if student name already exists it returns false
   public boolean checkStudent(String name)
   {
	
	   List<Student> studentlist=studentdao.findByName(name);
	   if(studentlist!=null && studentlist.size()>0)
	   {
		   return false;
	   }
	   
	   return true;
   }
	
	public  List<Student> findByQual(String qual)
	{
		return studentdao.findByQual(qual);
	}
	
	public List<Student> getStudents()
	{
		return studentdao.findAll();
	}
	
	
	public void verifyMessage() {
		System.out.println("I am syso");
		LOGGER.trace("I am trace");
		LOGGER.debug("I am debug");
		LOGGER.info("I am info");
		LOGGER.warn("I am warning");
		LOGGER.error("I am error");
	}
	
}
