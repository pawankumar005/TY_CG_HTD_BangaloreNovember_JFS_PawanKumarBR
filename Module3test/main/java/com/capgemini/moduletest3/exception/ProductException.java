package com.capgemini.moduletest3.exception;

public class ProductException {
	String message;

	public ProductException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
