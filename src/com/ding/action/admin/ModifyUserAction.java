package com.ding.action.admin;

import com.ding.dao.impl.JdbcAdminDAO;
import com.ding.pojo.ApiMsg;

public class ModifyUserAction {
	private JdbcAdminDAO jdbcAdminDao;
	private int user_id;
	String nickname="";
	String email="";

	public JdbcAdminDAO getJdbcAdminDao() {
		return jdbcAdminDao;
	}

	public void setJdbcAdminDao(JdbcAdminDAO jdbcAdminDao) {
		this.jdbcAdminDao = jdbcAdminDao;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String execute() throws Exception {
		jdbcAdminDao = new JdbcAdminDAO();
		jdbcAdminDao.modifyUser(user_id, nickname, email);
		return "success";
	}
	
	public static void main(String[] args) throws Exception {
		JdbcAdminDAO jdbcAdminDao = new JdbcAdminDAO();
		jdbcAdminDao.modifyUser(1, "123", "123");
		jdbcAdminDao.modifyUser(1, "123","");
		jdbcAdminDao.modifyUser(1, "", "123");
		jdbcAdminDao.modifyUser(1, "", "");
	}
}
