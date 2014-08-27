package com.ding.action.admin;

import com.ding.dao.impl.JdbcAdminDAO;
import com.ding.pojo.ApiMsg;

public class ModifyOrderAction {
	private JdbcAdminDAO jdbcAdminDao;
	private int order_id;
	double total_price=0.;
	String receive_name="";
	String mobile="";
	
	public JdbcAdminDAO getJdbcAdminDao() {
		return jdbcAdminDao;
	}


	public void setJdbcAdminDao(JdbcAdminDAO jdbcAdminDao) {
		this.jdbcAdminDao = jdbcAdminDao;
	}


	public int getOrder_id() {
		return order_id;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	public double getTotal_price() {
		return total_price;
	}


	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}


	public String getReceive_name() {
		return receive_name;
	}


	public void setReceive_name(String receive_name) {
		this.receive_name = receive_name;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	
	
	
	public String execute() throws Exception {
		jdbcAdminDao = new JdbcAdminDAO();
		jdbcAdminDao.modifyOrder(order_id, total_price, receive_name, mobile);
		return "success";
	}
}
