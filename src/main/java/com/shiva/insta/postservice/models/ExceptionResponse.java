package com.shiva.insta.postservice.models;

import java.util.Date;

public class ExceptionResponse {

	/*
	 * Fields
	 */
	private Date timestamp;
	private String status;
	private String message;
	private String path;

	
	/*
	 * Constructors
	 */
	public ExceptionResponse(String status, String message, String path) {
		super();
		this.timestamp = new Date();
		this.status = status;
		this.message = message;
		this.path = path;
	}


	/*
	 * Getters/Setters
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}


	/*
	 * Overridden methods
	 */
	@Override
	public String toString() {
		return "ExceptionResponse [timestamp=" + timestamp + ", status="
				+ status + ", message=" + message + ", path=" + path + "]";
	}	
	
}
