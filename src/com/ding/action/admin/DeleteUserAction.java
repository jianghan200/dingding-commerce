package com.ding.action.admin;

import com.ding.dao.impl.JdbcAdminDAO;
import com.ding.pojo.ApiMsg;
 
public class DeleteUserAction {
    private JdbcAdminDAO jdbcAdminDao;
    private int user_id;
    
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	private ApiMsg apiMsg = new ApiMsg();

	public ApiMsg getApiMsg() {
		return apiMsg;
	}

	public void setApiMsg(ApiMsg apiMsg) {
		this.apiMsg = apiMsg;
	}

	public JdbcAdminDAO getJdbcAdminDao() {
		return jdbcAdminDao;
	}
	public void setJdbcAdminDao(JdbcAdminDAO jdbcAdminDao) {
		this.jdbcAdminDao = jdbcAdminDao;
	}
	
	public String execute() throws Exception {
		jdbcAdminDao = new JdbcAdminDAO();
		jdbcAdminDao.deleteUser(user_id);
		apiMsg.setErrorCode(1);
		return "success";
	}
	
	
	public static void main(String[] args) throws Exception {
		System.out.println("1");
		JdbcAdminDAO jdbcAdminDao = new JdbcAdminDAO();
		System.out.println("2");
		jdbcAdminDao.deleteUser(1);
	}
}
