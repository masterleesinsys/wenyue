package com.wenyue.common;

import lombok.Data;

@Data
public class GlobleResult {

	private boolean success;
	private Object data;
	private String errmsg;
	
	public GlobleResult(boolean success, Object data, String errmsg) {
		super();
		this.success = success;
		this.data = data;
		this.errmsg = errmsg;
	}
	
	public static GlobleResult success(Object data) {
		return new GlobleResult(true, data, "");
	}
	
	public static GlobleResult fail(String errmsg) {
		return new GlobleResult(false, null, errmsg);
	}
	
}