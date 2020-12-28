package com.example.backendDB.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.backendDB.pojo.State;

@Repository
public interface StateDao extends JpaRepository<State, Integer> {
	
	
	@Query("select s from State s join s.country c where c.id=?1")
	public List<State> getStatesByCountry(Integer id);
	
}
