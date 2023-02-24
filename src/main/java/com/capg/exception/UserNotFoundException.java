package com.capg.exception;

public class UserNotFoundException extends RuntimeException {
	String msg;

	public UserNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}


}
