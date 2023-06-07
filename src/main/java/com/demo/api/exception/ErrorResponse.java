package com.demo.api.exception;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private String errorCode;
	private String errorMesssage;
	private HttpStatus httpStatus;
	
	

	public ErrorResponse() {
		
	}

	public ErrorResponse(String errorCode, String errorMesssage, HttpStatus httpStatus) {
		this.errorCode = errorCode;
		this.errorMesssage = errorMesssage;
		this.httpStatus = httpStatus;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMesssage() {
		return errorMesssage;
	}

	public void setErrorMesssage(String errorMesssage) {
		this.errorMesssage = errorMesssage;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	@Override
	public String toString() {
		return "ErrorResponse [errorCode=" + errorCode + ", errorMesssage=" + errorMesssage + ", httpStatus="
				+ httpStatus + "]";
	}

}
