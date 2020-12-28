package com.example.backendDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendDB.pojo.Country;
import com.example.backendDB.service.CountryService;

@RestController
@CrossOrigin
@RequestMapping("country")
public class CountryController {
	
	@Autowired
	private CountryService countryservice;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public ResponseEntity<List<Country>> getAllCountries()
	{
	List<Country> countries=countryservice.getAllCountries();
		ResponseEntity<List<Country>> re=new ResponseEntity<List<Country>>(countries,HttpStatus.OK);
		return re;
	}
	

}
