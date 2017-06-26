package com.iblogv.iblogvmanager.exception;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class IblogvException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3379993504727151822L;

	private String responseCode;

	private String responseMessage;

	public IblogvException(String errorCode, String errorMsg) {
		super(errorMsg);
		this.responseCode = errorCode;
		this.responseMessage = errorMsg;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}
}
