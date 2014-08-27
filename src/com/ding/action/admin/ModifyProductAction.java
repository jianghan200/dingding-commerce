package com.ding.action.admin;

import com.ding.dao.impl.JdbcAdminDAO;
import com.ding.pojo.ApiMsg;

public class ModifyProductAction {
	private JdbcAdminDAO jdbcAdminDao;
	private int product_id;
	String PRODUCT_NAME="";
	String DESCRIPTION= "";
	double fixed_price=0.;
	double dang_price=0.;

	public JdbcAdminDAO getJdbcAdminDao() {
		return jdbcAdminDao;
	}

	public void setJdbcAdminDao(JdbcAdminDAO jdbcAdminDao) {
		this.jdbcAdminDao = jdbcAdminDao;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}

	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}

	public String getDESCRIPTION() {
		return DESCRIPTION;
	}

	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}

	public double getFixed_price() {
		return fixed_price;
	}

	public void setFixed_price(double fixed_price) {
		this.fixed_price = fixed_price;
	}

	public double getDang_price() {
		return dang_price;
	}

	public void setDang_price(double dang_price) {
		this.dang_price = dang_price;
	}

	public String execute() throws Exception {
		jdbcAdminDao = new JdbcAdminDAO();
		jdbcAdminDao.modifyProduct(product_id, PRODUCT_NAME, DESCRIPTION, fixed_price, dang_price);
		return "success";
	}
}
