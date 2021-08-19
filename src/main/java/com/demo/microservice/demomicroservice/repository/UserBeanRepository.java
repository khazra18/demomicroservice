package com.demo.microservice.demomicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.microservice.demomicroservice.user.UserBean;

@Repository
public interface UserBeanRepository extends JpaRepository<UserBean, Integer>{

	
}
