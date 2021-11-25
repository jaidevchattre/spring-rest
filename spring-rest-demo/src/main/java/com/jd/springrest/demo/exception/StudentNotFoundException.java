package com.jd.springrest.demo.exception;

public class StudentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6961840107562588117L;
	
	public StudentNotFoundException() {
		
	}

	public StudentNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
		
	}

	public StudentNotFoundException(String message) {
		super(message);
	}

}
