package com.demo.api.advice;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.api.exception.ErrorResponse;
import com.demo.api.exception.UserNotFoundException;

@RestControllerAdvice
public class AppExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArgumentException(MethodArgumentNotValidException ex) {
		Map<String, String> errorMap = new HashMap<>();

		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}

	/*
	 * @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	 * 
	 * @ExceptionHandler(UserNotFoundException.class) public Map<String, String>
	 * handleUserNotFoundExcepiton(UserNotFoundException ex) { Map<String, String>
	 * errorMap = new HashMap<>(); errorMap.put("errorMessage", ex.getMessage());
	 * return errorMap; }
	 */

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {

		/*/      // when use constructor then error of representation.....
		 * ErrorResponse err = new ErrorResponse(UUID.randomUUID().toString(),
		 * ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		 */
		ErrorResponse err = new ErrorResponse();
		err.setErrorCode(UUID.randomUUID().toString());
		err.setErrorMesssage(ex.getMessage());
		err.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity<ErrorResponse>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
