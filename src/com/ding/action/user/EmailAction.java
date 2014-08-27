package com.ding.action.user;

import com.ding.dao.UserDAO;
import com.ding.service.UserService;
import com.ding.service.impl.UserServiceImpl;

public class EmailAction {
	/** input function */
	private String email;
	/** output function */
	private Boolean emailOk = false;

	// Spring Dependency Injection
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String execute() throws Exception {
		//System.out.println("fuck me and fuck you");
		/** handle requests by call service */
		userService = new UserServiceImpl();
		//System.out.println("fuck me");
		emailOk = userService.emailService(email);
		//System.out.println("fuck you");
		return "success";
	}

	public String getEmail() {
		return email;
	}

	public Boolean getEmailOk() {
		return emailOk;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmailOk(Boolean emailOk) {
		this.emailOk = emailOk;
	}

}
