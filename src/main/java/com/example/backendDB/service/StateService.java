package com.example.backendDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendDB.dao.StateDao;
import com.example.backendDB.pojo.State;

@Service
public class StateService {
	
	@Autowired
	private StateDao statedao;
	
	public List<State> getStatesByCountry(Integer id)
	{
	   return statedao.getStatesByCountry(id);
	}
}
	