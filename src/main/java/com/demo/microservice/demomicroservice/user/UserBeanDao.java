package com.demo.microservice.demomicroservice.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserBeanDao {

	private static List<UserBean> usersList = new ArrayList<>();
	
	private static int userCounts = 3;
	
	static {
		
		usersList.add(new UserBean(1, "krishanu", "kolkata"));
		usersList.add(new UserBean(2, "tirthankar", "barrackpore"));
		usersList.add(new UserBean(3, "suvadip", "naihati"));
		
	}
	
	public List<UserBean> findAll(){
		return usersList;
	}
	
	public UserBean saveUser(UserBean user) {
		if (user.getId() == 0) {
			user.setId(++userCounts);
		}
		
		usersList.add(user);
		return user;
	}
	
	public UserBean getUserByID(int id) {
		
		for(UserBean user : usersList) {
			if(user.getId() == id) {
				return user;
			}
		}
		
		return null;
	}
	
}
