package com.example.backendDB.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class StudentAdderssPojo {

	@Id
	@GeneratedValue
	private Integer id;
	private String doorNumber;
	
	@ManyToOne
	@JoinColumn(name="stid")
	private Student studentpojo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}

	public Student getStudentpojo() {
		return studentpojo;
	}

	public void setStudentpojo(Student studentpojo) {
		this.studentpojo = studentpojo;
	}
	
	
	
}
