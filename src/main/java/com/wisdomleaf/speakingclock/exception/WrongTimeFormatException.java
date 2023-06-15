package com.wisdomleaf.speakingclock.exception;

public class WrongTimeFormatException extends RuntimeException{
 
	private static final long serialVersionUID = 1L;

	public WrongTimeFormatException() {
		super();
	}
	
	public WrongTimeFormatException(String message) {
		super(message);
	}
}
