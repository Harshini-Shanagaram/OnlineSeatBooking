package com.capg.exception;

public class BookingNotFoundException extends RuntimeException{
	String msg;

	public BookingNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}



}
