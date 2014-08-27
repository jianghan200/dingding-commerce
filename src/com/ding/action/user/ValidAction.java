package com.ding.action.user;

import com.ding.action.BaseAction;

public class ValidAction extends BaseAction {
	//input
	private String code;
	//output -->json
	private Boolean ok = false;
	
	public String execute() throws Exception{
		Thread.sleep(2000);
		//比较
		String scode = (String)session.get("code");
		if(code.equals(scode)){
			ok=true;
		}else{
			ok=false;
		}
		//调用jsonResult输出ok
		return "success";
	}
	public String getCode() {
		return code;
	}
	public Boolean getOk() {
		return ok;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setOk(Boolean ok) {
		this.ok = ok;
	}
	
	
}
