package com.example.backendDB.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="distic")
public class DisticPojo {

	@Id
	@GeneratedValue
	private Integer id;
	private String disticname;
	@ManyToOne
	@JoinColumn(name="did")
	private State state;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDisticname() {
		return disticname;
	}
	public void setDisticname(String disticname) {
		this.disticname = disticname;
	}
	
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	
	
	
}
