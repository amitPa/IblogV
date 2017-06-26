package com.iblogv.iblogvmanagerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iblogv.iblogvmanager.domain.ResponseCode;
import com.iblogv.iblogvmanager.domain.User;
import com.iblogv.iblogvmanager.exception.IblogvException;
import com.iblogv.iblogvmanager.model.UserEntity;
import com.iblogv.iblogvmanager.service.UserService;
import com.iblogv.iblogvmanagerapi.config.BearerTokenRequired;
import com.iblogv.iblogvmanagerapi.config.BearerTokenRequired.TokenOwner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	private ResponseCode createUser(@RequestBody User user) throws IblogvException{
		
		log.debug("Begin start create user");
		return userService.createUser(user);
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@BearerTokenRequired(TokenOwner.USER)
	private List<UserEntity> fetchUsers() throws IblogvException{
		
		log.debug("Begin start create user");
		return userService.fetchUsers();
		
	}
}
