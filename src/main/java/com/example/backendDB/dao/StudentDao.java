package com.example.backendDB.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.backendDB.pojo.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
	
	
	@Query("from Student where name=?1")
	public abstract List<Student> getStd(String name);
	
	public abstract List<Student> findByName(String name);
	
	public abstract List<Student> findByQual(String qual);
	
	//public boolean findByName(String name);

}
