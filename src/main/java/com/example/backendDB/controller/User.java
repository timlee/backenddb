package com.example.backendDB.controller;

public class User {
	
	private String name;
	private String batch;
	

	public User(String string, String string2) {
		
		this.name=string;
		this.batch=string2;

	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBatch() {
		return batch;
	}


	public void setBatch(String batch) {
		this.batch = batch;
	}

}
