package com.example.backendDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendDB.pojo.State;
import com.example.backendDB.service.StateService;

@RestController
@CrossOrigin
@RequestMapping("state")
public class StateController {
	
	@Autowired
	private StateService stateservice;
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<List<State>> getStatesByCountry(@PathVariable Integer id)
	{
	
		List<State> statelist=stateservice.getStatesByCountry(id);
		ResponseEntity<List<State>> re=new ResponseEntity<List<State>>(statelist,HttpStatus.OK);
		return re;
		
	}
	
	

}
