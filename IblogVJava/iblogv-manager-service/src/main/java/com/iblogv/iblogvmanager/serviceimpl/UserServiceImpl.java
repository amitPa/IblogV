package com.iblogv.iblogvmanager.serviceimpl;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.iblogv.iblogvmanager.domain.Auth;
import com.iblogv.iblogvmanager.domain.ResponseCode;
import com.iblogv.iblogvmanager.domain.User;
import com.iblogv.iblogvmanager.exception.IblogvException;
import com.iblogv.iblogvmanager.model.UserEntity;
import com.iblogv.iblogvmanager.repository.UserJpaRepository;
import java.util.List;
import com.iblogv.iblogvmanager.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserJpaRepository userJpaRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private TokenServiceImpl tokenService;

	@Override
	public ResponseCode createUser(User user) throws IblogvException {

		log.debug("Create User Start");

		UserEntity userEntity = new UserEntity();
		StringBuilder stringBuilder = new StringBuilder();

		if (StringUtils.isBlank(user.getEmail()))
			stringBuilder.append("UserEmail missing");

		if (StringUtils.isBlank(user.getPassword()))
			stringBuilder.append("UserPassword missing");

		if (StringUtils.isBlank(user.getName()))
			stringBuilder.append("UserName missing");

		if (stringBuilder.length() > 0)
			throw new IblogvException("IM-400", stringBuilder.toString());

		userEntity.setEmail(user.getEmail());
		userEntity.setPassword(StringUtils.trim(user.getPassword()));
		//userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
		userEntity.setUserId("IM-".concat(UUID.randomUUID().toString()));

		userJpaRepository.save(userEntity);

		return new ResponseCode("IM200", "User created successfuly");

	}

	@Override
	public ResponseCode authUser(Auth user) throws IblogvException {

		log.debug("Create User Start");

		UserEntity userEntity = new UserEntity();
		StringBuilder stringBuilder = new StringBuilder();

		if (StringUtils.isBlank(user.getEmail()))
			stringBuilder.append("UserEmail missing");

		if (StringUtils.isBlank(user.getPassword()))
			stringBuilder.append("UserPassword missing");

		if (stringBuilder.length() > 0)
			throw new IblogvException("IM-400", stringBuilder.toString());
		String passwordEncode=passwordEncoder.encode(user.getPassword());
		if (userJpaRepository.authUser(user.getEmail(),StringUtils.trim(user.getPassword())) != null){
			return new ResponseCode("IM200", "User created successfuly your token is ".concat(tokenService.generateToken(user)));
		}
		else
			return new ResponseCode("IM400", "User verification failed");

	}

	@Override
	public List<UserEntity> fetchUsers() throws IblogvException {
		return userJpaRepository.findAll();
	}

}
