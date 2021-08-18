package com.demo.microservice.demomicroservice.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservice.demomicroservice.exception.UserNotFoundException;

@RestController
public class UserController {

	@Autowired
	private UserBeanDao userBeanDao;

	@GetMapping("/users")
	public List<UserBean> retrieveAllUsers() {
		return userBeanDao.findAll();
	}

	@GetMapping("/users/{id}")
	public UserBean getUserByID(@PathVariable int id) {

		UserBean userByID = userBeanDao.getUserByID(id);
		if (userByID == null)
			throw new UserNotFoundException("ID - " + id);

		return userByID;
	}

	@PostMapping("/addusers")
	public UserBean addUsers(@RequestBody UserBean user) {
		return userBeanDao.saveUser(user);
	}

}
