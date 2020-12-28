package com.example.backendDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendDB.dao.CountryDao;
import com.example.backendDB.pojo.Country;

@Service
public class CountryService {
	
	@Autowired
	private CountryDao countrydao;
	
	public List<Country> getAllCountries()
	{
		return countrydao.findAll();
	}
	

}
