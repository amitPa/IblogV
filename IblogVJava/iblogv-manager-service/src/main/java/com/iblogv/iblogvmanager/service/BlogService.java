package com.iblogv.iblogvmanager.service;

import com.iblogv.iblogvmanager.domain.Blog;
import com.iblogv.iblogvmanager.domain.ResponseCode;
import com.iblogv.iblogvmanager.exception.IblogvException;

public interface BlogService {

	public ResponseCode createBlog(Blog blog)throws IblogvException;
	
}
