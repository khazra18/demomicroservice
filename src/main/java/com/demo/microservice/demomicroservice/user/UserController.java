package com.demo.microservice.demomicroservice.user;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservice.demomicroservice.exception.UserNotFoundException;
import com.demo.microservice.demomicroservice.repository.UserBeanRepository;

@RestController
public class UserController {

	@Autowired
	private UserBeanDao userBeanDao;

	@Autowired
	private UserBeanRepository userBeanRepository;

	@GetMapping("/jpa/users")
	public List<UserBean> retrieveAllUsers() {
		return userBeanRepository.findAll();
	}

	@GetMapping("/jpa/users/{id}")
	public Optional<UserBean> getUserByID(@PathVariable int id) {

		Optional<UserBean> userByID = userBeanRepository.findById(id);
		if (!userByID.isPresent())
			throw new UserNotFoundException("ID - " + id);

		return userByID;
	}

	@PostMapping("/jpa/addusers")
	public UserBean addUsers(@Valid @RequestBody UserBean user) {
		return userBeanRepository.save(user);
	}

	@DeleteMapping("/jpa/users/{id}")
	public void deleteUsers(@PathVariable int id) {
		if (!userBeanRepository.existsById(id)) {
			throw new UserNotFoundException("ID - " + id);
		}
		userBeanRepository.deleteById(id);

	}

}
