package com.neil.exceptions;

public class UserException extends RuntimeException {
	private static final long serialVersionUID = 2381826495075445870L;

	public UserException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

	public UserException(String message, Throwable cause) {
		// TODO Auto-generated constructor stub
		super(message, cause);
	}
}
