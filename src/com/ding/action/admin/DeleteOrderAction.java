package com.ding.action.admin;

import com.ding.dao.impl.JdbcAdminDAO;
import com.ding.pojo.ApiMsg;

public class DeleteOrderAction {
	private JdbcAdminDAO jdbcAdminDao;
	private int order_id;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
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
		jdbcAdminDao.deleteOrder(order_id);
		apiMsg.setErrorCode(1);
		return "success";
	}
}
