package com.ding.action.user;

import java.sql.SQLException;

import com.ding.action.BaseAction;
import com.ding.dao.UserDAO;
import com.ding.dao.impl.JdbcUserDAO;
import com.ding.pojo.User;
import com.ding.service.UserService;
import com.ding.service.impl.UserServiceImpl;
import com.ding.util.EncryptUtil;

public class LoginAction extends BaseAction {
	// input
	private String name;
	private String password;

	// output
	private String msg;
	private Boolean loginEmailOk = false;


	//Spring Dependency Injection
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//Spring Dependency Injection
	private UserDAO userDao;
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public String execute() throws Exception {

		loginEmailOk = userService.emailService(name);
		System.out.println("loginEmailOk" + loginEmailOk);
		User user = userDao.fiandEmail(name);
		System.out.println(user.getEmail());
		String pwd = EncryptUtil.md5Encrypt(password);
		System.out.println(user.getEmailVerify().toString());
		session.get("rlogin");

		if (loginEmailOk == false && user.getPassword().equals(pwd)) {
			if (user.getEmailVerify().equals("N")) {
				msg = "你的邮箱还没验证";
				return "fail";
			}
			user.setLastLoginTime(System.currentTimeMillis());
			System.out.println("ok");
			user.setLastLoginIp(httpRequest.getRemoteAddr());
			userDao.updateTimeAndIp(user.getLastLoginTime(),
					user.getLastLoginIp(), user.getEmail());
			session.put("user", user);
			return "success";
		} else {
			msg = "邮箱或密码错误";
			return "fail";
		}

	}

	public String exit() {
		session.remove("user");
		if (session.get("user") == null) {
			System.out.println("session已经删除了");
		}
		return "success";
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
