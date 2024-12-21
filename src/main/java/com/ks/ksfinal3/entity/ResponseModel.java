package com.ks.ksfinal3.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ResponseModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private int statusCode;
	private HttpStatus status;
	private String message;
	private Object data;
	private List<String> errors;

	public ResponseModel(int statuscode, HttpStatus status, String message, Object data, List<String> errors) {
		this.statusCode = statuscode;
		this.status = status;
		this.message = message;
		this.data = data;
		this.errors = errors;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
