package com.uol.productms.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer status_code;
	private String message;
	
	
	//Constructor
	public StandardError() {

	}


	public StandardError(Integer status_code, String message) {
		super();
		this.status_code = status_code;
		this.message = message;
	}

	//Getters and Setters
	public Integer getStatus_code() {
		return status_code;
	}


	public void setStatus_code(Integer status_code) {
		this.status_code = status_code;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	


	
	


	
	
}
