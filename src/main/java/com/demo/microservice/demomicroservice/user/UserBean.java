package com.demo.microservice.demomicroservice.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity(name = "userbean")
public class UserBean {

	@Id
	@GeneratedValue
	private int id;
	
	@Size(min = 2, message = "Name should have atleast more than two characters")
	private String name;
	
	private String cityName;

	public UserBean() {

	}

	public UserBean(int id, String name, String cityName) {
		this.id = id;
		this.name = name;
		this.cityName = cityName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
