package com.iblogv.iblogvmanagerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iblogv.iblogvmanager.domain.Blog;
import com.iblogv.iblogvmanager.domain.ResponseCode;
import com.iblogv.iblogvmanager.exception.IblogvException;
import com.iblogv.iblogvmanager.service.BlogService;
import com.iblogv.iblogvmanagerapi.config.BearerTokenRequired;
import com.iblogv.iblogvmanagerapi.config.BearerTokenRequired.TokenOwner;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Amit Pandey
 *
 */
@Slf4j
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("blog")
public class BlogController {

	@Autowired
	BlogService blogService;
	
	@RequestMapping(method = RequestMethod.POST)
	@BearerTokenRequired(TokenOwner.USER)
	private ResponseCode createBlog(@RequestBody Blog blog) throws IblogvException{
		log.debug("Begin creating blog");
		return blogService.createBlog(blog);
	}
}
