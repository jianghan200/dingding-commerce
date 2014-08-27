package com.ding.service.impl;

import java.sql.SQLException;

import com.ding.dao.UserDAO;
import com.ding.dao.impl.JdbcUserDAO;
import com.ding.pojo.User;
import com.ding.service.UserService;
import com.ding.util.Constant;
import com.ding.util.EmailUtil;
import com.ding.util.EncryptUtil;
import com.ding.util.VerifyUtil;

public class UserServiceImpl implements UserService{
		//Spring injection
	private UserDAO userDao;

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}


	public void regist(User user) throws Exception {
		 //设置非表单信�?
	    //将密码加�?
	    String pwd = EncryptUtil.md5Encrypt(
	              user.getPassword());
	    user.setPassword(pwd);
	    //等级
	    user.setUserIntegral(Constant.NORMAL);
	//  email未�?过验�?
	    user.setEmailVerify("Y");
	//  �?��登录时间
	    user.setLastLoginTime(
	        System.currentTimeMillis());
	//  邮箱验证�?
	    String verifyCode = 
	      VerifyUtil.createVerifyCode();
	    user.setEmailVerifyCode(verifyCode);
	    //保存用户信息
	    userDao.save(user);
	    //将邮箱验证码发�?邮件,格式为verifyCode-id
	    String emailVerifyCode = verifyCode+"-"+user.getUSER_ID();
	    //发邮�?
	    EmailUtil.sendEmail(
	        user.getEmail(),
	        emailVerifyCode);
	  }
	//邮箱验证
	public Boolean emailService(String email) throws Exception {
		
		User user = userDao.fiandEmail(email);
		if(user.getUSER_ID() == null){
		  return true;
		}else{
		  return false;
		}
	}
	
	public Boolean isEmailExist(String email) throws SQLException{
		
		User user = userDao.fiandEmail(email);

		if(user == null){
			return false;
		}else{
			return true;
		}
		
	}
	
	
}
