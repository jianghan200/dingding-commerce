package com.ding.dao;

import java.sql.SQLException;

import com.ding.pojo.User;

public interface UserDAO {
	/**
	 * save user into database
	 * @param user
	 * @throws SQLException
	 */
	public void save(User user)throws SQLException;
	/**
	 * get user by email
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	public User fiandEmail(String email)throws SQLException;
	/**
	 * get verify code by user's id
	 * @param id user's id
	 * @return
	 * @throws SQLException
	 */
	public User findVerifyCode(int id)throws SQLException;
	/**
	 * insert whether email has pass the verify
	 * @param is_email_verify
	 * @param id
	 * @throws SQLException
	 */
	public void addEmailVerify(String is_email_verify,int id)throws SQLException;
	/**
	 * update last login time and IP
	 * @param lastLogiantime
	 * @param lastLoginIp
	 * @param email
	 * @throws SQLException
	 */
	public void updateTimeAndIp(long lastLogiantime,String lastLoginIp,String email)throws SQLException;
}
