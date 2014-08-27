package com.ding.action.user;



import com.ding.action.BaseAction;

import com.ding.pojo.User;
import com.ding.service.UserService;
import com.ding.service.impl.UserServiceImpl;

public class RegisterAction extends BaseAction{
	//input
	private User user;
	//output
	private String emailVerifyCode;
	
	
	//Spring Dependency Injection
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String execute() throws Exception{
		
		System.out.println("I am here");
		//最后登录Ip
		user.setLastLoginIp(httpRequest.getRemoteAddr());
		System.out.println("I am here 1");
		//调用Service完成请求处理
		userService.regist(user);
		System.out.println("I am here 2");
	    //将verifyCode-id格式的code显示到页面
	    emailVerifyCode = user.getEmailVerifyCode()+"-"+user.getUSER_ID();
	    System.out.println("I am here 3");
	    session.put("emailVerify", emailVerifyCode);
	    
		return "verify";
	}
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getEmailVerifyCode() {
		return emailVerifyCode;
	}
	
	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}
	
}
