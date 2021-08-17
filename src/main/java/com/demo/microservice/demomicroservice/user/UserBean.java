package com.demo.microservice.demomicroservice.user;

public class UserBean {

	private int id;
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
