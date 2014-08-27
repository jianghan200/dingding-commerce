package com.ding.action.admin;

import com.ding.dao.impl.JdbcAdminDAO;
import com.ding.pojo.User;

public class AddUserAction {
    private JdbcAdminDAO jdbcAdminDao;
    
    
    private User user;
    public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}


	private String email;
	private String nickname;
    private String password;
    
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public JdbcAdminDAO getJdbcAdminDao() {
		return jdbcAdminDao;
	}
	public void setJdbcAdminDao(JdbcAdminDAO jdbcAdminDao) {
		this.jdbcAdminDao = jdbcAdminDao;
	}
	
	public String execute() throws Exception {
		
		System.out.println("1111");
		System.out.println(user.getEmail());
		System.out.println(user.getNickname());
		System.out.println(user.getPassword());
		
		jdbcAdminDao = new JdbcAdminDAO();
		jdbcAdminDao.addUser(user.getEmail(), user.getNickname(), user.getPassword());
		return "success";
	}
	
	
	public static void main(String[] args) throws Exception {

	}
}
