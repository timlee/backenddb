package com.example.backendDB.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String helloMethod()
	{
		return "welcome batch19!";
	}
	
	@RequestMapping(value="/json",method=RequestMethod.GET)
	public User jsonHello()
	{
		return new User("mamatha","batch19");
	}
	
	@RequestMapping(value="/jsonList",method=RequestMethod.GET)
	public List<User> jsonListHello()
	{
		
		List<User> list   = new ArrayList<User>();
		list.add(new User("mamatha1","batch19"));
		list.add(new User("mamatha2","batch19"));
		return list ;
	}

}
