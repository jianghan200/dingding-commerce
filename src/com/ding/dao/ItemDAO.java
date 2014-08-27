package com.ding.dao;

import java.sql.SQLException;

import com.ding.pojo.Item;
/**
 * packaging the detail info into item
 * @author Administrator
 *
 */
public interface ItemDAO {
	public void addItem(Item item)throws SQLException;
}
