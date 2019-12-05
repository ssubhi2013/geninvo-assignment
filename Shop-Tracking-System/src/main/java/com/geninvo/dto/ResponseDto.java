package com.geninvo.dto;

/**
 * @author Satnam Singh This is a generic class to send a response from various
 *         services/controllers
 * @param <T>
 */
public class ResponseDto<T> {
	private boolean success;
	private T result;
	private String message = "Something Went Wrong...";
	private int totalRecords;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
}
