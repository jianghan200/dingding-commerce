package com.ding.action.user;

import java.sql.SQLException;

import com.ding.action.BaseAction;
import com.ding.dao.UserDAO;
import com.ding.pojo.User;

public class VerifyAction extends BaseAction {
	// output
	private User user;

	// Spring Dependency Injection
	private UserDAO userDao;
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public String execute() throws SQLException {

		String verifyCode = (String) session.get("emailVerify");
		String ids = verifyCode.substring(verifyCode.lastIndexOf("-") + 1);
		int id = Integer.parseInt(ids);

		user = userDao.findVerifyCode(id);

		userDao.addEmailVerify("Y", id);
		return "success";

	}




}
