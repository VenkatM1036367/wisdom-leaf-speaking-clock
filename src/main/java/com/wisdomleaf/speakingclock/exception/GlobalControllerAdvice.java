package com.wisdomleaf.speakingclock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception ex) {
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// configure all customized exceptions here

	@ExceptionHandler(WrongTimeFormatException.class)
	public ResponseEntity<Object> handleWrongTimeFormatException(WrongTimeFormatException wrte) {
		return new ResponseEntity<Object>(wrte.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
