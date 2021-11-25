package com.jd.springrest.demo.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jd.springrest.demo.exception.StudentErrorResponse;
import com.jd.springrest.demo.exception.StudentNotFoundException;

@ControllerAdvice
public class StudentRestExceptionHandler {
	@Autowired
	StudentErrorResponse error;
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<StudentErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception e){
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<StudentErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}

}
