package com.iblogv.iblogvmanagerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iblogv.iblogvmanager.domain.Auth;
import com.iblogv.iblogvmanager.domain.ResponseCode;
import com.iblogv.iblogvmanager.exception.IblogvException;
import com.iblogv.iblogvmanager.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("auth")
public class AuthenticationController {

	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	private ResponseCode authenticate(@RequestBody Auth auth) throws IblogvException{
		log.debug("Begin authenticating user");
		
	return userService.authUser(auth);
	
	}
}
