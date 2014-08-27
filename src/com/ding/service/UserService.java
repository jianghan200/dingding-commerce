package com.ding.service;

import com.ding.pojo.User;

public interface UserService {
	public void regist(User user) throws Exception;
	public Boolean emailService(String email)throws Exception;
}
