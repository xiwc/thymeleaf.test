package org.xiwc.semantic.model;

import java.io.Serializable;

public class RespBody implements Serializable {

	/** serialVersionUID long */
	private static final long serialVersionUID = -1965817463440121331L;
	public boolean success;
	public String message;
	public Object data;

	public RespBody() {
	}

	public RespBody(boolean success) {
		this.success = success;
	}

	public RespBody(boolean success, Object data) {
		this.success = success;
		this.data = data;
	}

	public RespBody(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public RespBody(boolean success, String message, Object data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
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

}
