package com.iblogv.iblogvmanager.service;

import com.iblogv.iblogvmanager.domain.ResponseCode;
import com.iblogv.iblogvmanager.exception.IblogvException;

public interface TokenService {

	public ResponseCode  validateAccessToken(String code) throws IblogvException;
}
