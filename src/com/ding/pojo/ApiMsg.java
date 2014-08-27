package com.ding.pojo;

public class ApiMsg {
	
	private int errorCode = 0;
	
	private String errorMsg = "请求成功";

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "{\"ApiMsg\":[\"errorCode\":\"" + errorCode + "\",\"errorMsg\"" + errorMsg
				+ "\"]}";
	}
	
}
