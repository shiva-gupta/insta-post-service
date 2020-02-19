package com.shiva.insta.postservice.models;

public class Response {

	/*
	 * Fields
	 */
	private String status;
	private Boolean success;
	private String message;
	private Object data;
	
	
	/*
	 * Constructors
	 */
	public Response() {
		super();
	}

	public Response(String status, Boolean success) {
		super();
		this.status = status;
		this.success = success;
	}

	public Response(Boolean success, String message, Object data) {
		super();
		this.success = success;
		this.message = message;
		this.data = data;
	}
	
	public Response(String status, Boolean success, String message, Object data) {
		super();
		this.status = status;
		this.success = success;
		this.message = message;
		this.data = data;
	}
	

	/*
	 * Getters/Setters
	 */
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	
	/*
	 * Overriden methods
	 */
	@Override
	public String toString() {
		return "Response [status=" + status + ", success=" + success
				+ ", message=" + message + ", data=" + data + "]";
	}
	
}
