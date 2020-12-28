package com.example.backendDB.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String qual;
	private Integer phone;
	
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQual() {
		return qual;
	}
	public void setQual(String qual) {
		this.qual = qual;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", qual=" + qual + ", phone=" + phone + "]";
	}
	

}
