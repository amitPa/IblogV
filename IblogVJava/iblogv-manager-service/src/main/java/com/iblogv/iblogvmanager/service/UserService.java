package com.iblogv.iblogvmanager.service;

import java.util.List;

import com.iblogv.iblogvmanager.domain.Auth;
import com.iblogv.iblogvmanager.domain.ResponseCode;
import com.iblogv.iblogvmanager.domain.User;
import com.iblogv.iblogvmanager.exception.IblogvException;
import com.iblogv.iblogvmanager.model.UserEntity;

public interface UserService {

	public ResponseCode createUser(User user) throws IblogvException;
	
	public ResponseCode authUser(Auth user) throws IblogvException;
	
	public List<UserEntity> fetchUsers() throws IblogvException;
}
