package com.jd.springdemo.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	@Autowired
	private CustomerErrorResponse error;
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException e){
	   error.setMessage(e.getMessage());
	   error.setStatus(HttpStatus.NOT_FOUND.value());
	   error.setTimestamp(System.currentTimeMillis());
	   
	   return new ResponseEntity<CustomerErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception e){
	   error.setMessage(e.getMessage());
	   error.setStatus(HttpStatus.BAD_REQUEST.value());
	   error.setTimestamp(System.currentTimeMillis());
	   
	   return new ResponseEntity<CustomerErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}
}
