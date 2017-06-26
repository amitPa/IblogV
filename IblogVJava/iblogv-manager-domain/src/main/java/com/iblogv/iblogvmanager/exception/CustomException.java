package com.iblogv.iblogvmanager.exception;

import lombok.Data;

@Data
public class CustomException  {

	private String responseCode;
	private String responseMessage;

	public String getResponseCode() {
		return responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public CustomException(String errorCode, String errorMsg) {
		this.responseCode = errorCode;
		this.responseMessage = errorMsg;
	}
}
