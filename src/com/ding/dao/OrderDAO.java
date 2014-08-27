package com.ding.dao;

import java.sql.SQLException;

import com.ding.pojo.Order;
/**
 * add an order on the database
 * @author Administrator
 *
 */
public interface OrderDAO {
	public void addOrder(Order order) throws SQLException;
}
