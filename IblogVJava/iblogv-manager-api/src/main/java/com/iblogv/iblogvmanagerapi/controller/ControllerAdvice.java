package com.iblogv.iblogvmanagerapi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.iblogv.iblogvmanager.exception.CustomException;
import com.iblogv.iblogvmanager.exception.IblogvException;



//@CrossOrigin(origins = "https://id.mitangi.com")
@CrossOrigin(maxAge = 3600)
@RestController
@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(IblogvException.class)
	@ResponseBody
	public CustomException customException(IblogvException resp){
		return new CustomException(resp.getResponseCode(),resp.getResponseMessage());
	}
	
	
}
